package com.udyog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.udyog.bo.CityBo;
import com.udyog.bo.JobBo;
import com.udyog.bo.JobCategoryBo;
import com.udyog.bo.StateBo;

@Repository
public class JobDaoImpl implements JobDao {
	private final String SQL_GET_JOBS = "select j.*, jc.*, c.*, s.* from job j inner join job_categories jc on j.job_category_no = jc.category_no inner join cities c on j.city_no = c.city_no inner join states s on j.state_no = s.state_no order by j.opening_dt desc";
	private final String SQL_GET_JOB_BY_JOBNO = "select j.*, jc.*, c.*, s.* from job j inner join job_categories jc on j.job_category_no = jc.category_no inner join cities c on j.city_no = c.city_no inner join states s on j.state_no = s.state_no where j.job_no = ?";
	private final String SQL_CREATE_JOB = "insert into job(title, description, company_nm, experience, job_posted_dt, opening_dt, closing_dt, skills, city_no, state_no, country, job_category_no, status) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String SQL_UPDATE_JOB = "update job set title = ?, description = ?, company_nm = ?, experience = ?, opening_dt = ?, closing_dt = ?, skills = ?, city_no = ?, state_no = ?, country = ?, job_category_no = ? where job_no = ?";
	private final String SQL_GET_JOB_CATEGORIES = "select category_no, category_nm, description from job_categories order by category_nm";
	private final String SQL_GET_CITIES = "select city_no, city_nm from cities order by city_nm";
	private final String SQL_GET_STATES = "select state_no, state_nm from states order by state_nm";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<JobBo> getJobs() {
		return jdbcTemplate.query(SQL_GET_JOBS, new JobRowMapper());
	}

	@Override
	public int saveJob(final JobBo job) {
		KeyHolder keyHolder = null;

		keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pstmt = null;

				pstmt = con.prepareStatement(SQL_CREATE_JOB, new String[] { "job_no" });
				
				pstmt.setString(1, job.getTitle());
				pstmt.setString(2, job.getDescription());
				pstmt.setString(3, job.getCompanyName());
				pstmt.setInt(4, job.getExperience());
				pstmt.setDate(5, new java.sql.Date(job.getJobPostedDate().getTime()));
				pstmt.setDate(6, new java.sql.Date(job.getOpeningDate().getTime()));
				pstmt.setDate(7, new java.sql.Date(job.getClosingDate().getTime()));
				pstmt.setString(8, job.getSkills());
				pstmt.setInt(9, job.getCity().getCityNo());
				pstmt.setInt(10, job.getState().getStateNo());
				pstmt.setString(11, job.getCountry());
				pstmt.setInt(12, job.getJobCategory().getJobCategoryNo());
				pstmt.setString(13, job.getStatus());
				return pstmt;
			}
		}, keyHolder);
		return keyHolder.getKey().intValue();
	}

	@Override
	public void updateJob(JobBo job) {
		jdbcTemplate.update(SQL_UPDATE_JOB,
				new Object[] { job.getTitle(), job.getDescription(), job.getCompanyName(), job.getExperience(),
						job.getOpeningDate(), job.getClosingDate(), job.getSkills(), job.getCity().getCityNo(),
						job.getState().getStateNo(), job.getCountry(), job.getJobCategory().getJobCategoryNo(),
						job.getJobNo() });
	}

	@Override
	public JobBo getJob(int jobNo) {
		return jdbcTemplate.queryForObject(SQL_GET_JOB_BY_JOBNO, new JobRowMapper(), new Object[] { jobNo });
	}

	@Override
	public List<JobCategoryBo> getJobCategories() {
		return jdbcTemplate.query(SQL_GET_JOB_CATEGORIES, new RowMapper<JobCategoryBo>() {
			@Override
			public JobCategoryBo mapRow(ResultSet rs, int rowNum) throws SQLException {
				JobCategoryBo jobCategoryBo = null;

				jobCategoryBo = new JobCategoryBo(rs.getInt("category_no"), rs.getString("category_nm"),
						rs.getString("description"));
				return jobCategoryBo;
			}

		});
	}

	@Override
	public List<CityBo> getCities() {
		return jdbcTemplate.query(SQL_GET_CITIES, new RowMapper<CityBo>() {
			@Override
			public CityBo mapRow(ResultSet rs, int rowNum) throws SQLException {
				CityBo city = null;
				city = new CityBo(rs.getInt("city_no"), rs.getString("city_nm"));
				return city;
			}

		});
	}

	@Override
	public List<StateBo> getStates() {
		return jdbcTemplate.query(SQL_GET_STATES, new RowMapper<StateBo>() {

			@Override
			public StateBo mapRow(ResultSet rs, int rowNum) throws SQLException {
				StateBo state = null;
				state = new StateBo(rs.getInt("state_no"), rs.getString("state_nm"));
				return state;
			}

		});
	}

	private final class JobRowMapper implements RowMapper<JobBo> {
		@Override
		public JobBo mapRow(ResultSet rs, int rowNum) throws SQLException {
			JobBo bo = null;
			JobCategoryBo jobCategoryBo = null;
			CityBo cityBo = null;
			StateBo stateBo = null;

			bo = new JobBo();
			bo.setJobNo(rs.getInt("j.job_no"));
			bo.setTitle(rs.getString("j.title"));
			bo.setDescription(rs.getString("j.description"));
			bo.setCompanyName(rs.getString("j.company_nm"));
			bo.setExperience(rs.getInt("j.experience"));
			bo.setJobPostedDate(rs.getDate("j.job_posted_dt"));
			bo.setOpeningDate(rs.getDate("j.opening_dt"));
			bo.setClosingDate(rs.getDate("j.closing_dt"));
			bo.setSkills(rs.getString("j.skills"));
			bo.setCountry(rs.getString("j.country"));
			bo.setStatus(rs.getString("j.status"));

			jobCategoryBo = new JobCategoryBo(rs.getInt("jc.category_no"), rs.getString("jc.category_nm"),
					rs.getString("jc.description"));
			cityBo = new CityBo(rs.getInt("c.city_no"), rs.getString("c.city_nm"));
			stateBo = new StateBo(rs.getInt("s.state_no"), rs.getString("s.state_nm"));

			bo.setJobCategory(jobCategoryBo);
			bo.setCity(cityBo);
			bo.setState(stateBo);

			return bo;
		}
	}

}
