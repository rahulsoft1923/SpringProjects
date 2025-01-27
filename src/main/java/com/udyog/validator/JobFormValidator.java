package com.udyog.validator;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.udyog.form.JobForm;

@Component
public class JobFormValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(JobForm.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		JobForm jobForm = null;

		jobForm = (JobForm) target;
		if (isEmpty(jobForm.getTitle())) {
			errors.rejectValue("title", "title.blank");
		}
		if (isEmpty(jobForm.getDescription())) {
			errors.rejectValue("description", "description.blank");
		}
		if (isEmpty(jobForm.getCompanyName())) {
			errors.rejectValue("companyName", "companyName.blank");
		}
		if (jobForm.getOpeningDate() == null) {
			errors.rejectValue("openingDate", "openingDate.blank");
		}
		if (jobForm.getClosingDate() == null) {
			errors.rejectValue("closingDate", "closingDate.blank");
		}
		Date today = new Date();
		if (errors.hasFieldErrors("openingDate") == false) {
			if (today.compareTo(jobForm.getOpeningDate()) == 1) {
				errors.rejectValue("openingDate", "openingDate.future");
			}
		}
		if (errors.hasFieldErrors("closingDate") == false) {
			if (today.compareTo(jobForm.getClosingDate()) == 1) {
				errors.rejectValue("closingDate", "closingDate.future");
			} else if (jobForm.getOpeningDate().compareTo(jobForm.getClosingDate()) == 1) {
				errors.rejectValue("closingDate", "closingDate.beforeOpeningDate");
			}
		}
		if (isEmpty(jobForm.getCountry())) {
			errors.rejectValue("country", "country.blank");
		}

	}

	private boolean isEmpty(String s) {
		if (s == null || s.trim().length() == 0) {
			return true;
		}
		return false;
	}

}
