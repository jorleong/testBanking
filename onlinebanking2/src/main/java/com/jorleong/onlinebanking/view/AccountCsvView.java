package com.jorleong.onlinebanking.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.AbstractView;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import com.jorleong.onlinebanking.domain.Account;

public class AccountCsvView extends AbstractView{

	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setContentType(getContentType());
		buildCsvDocument(model, request, response);
		
		
	}

	public void buildCsvDocument(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);
		List<Account> accountList = (List<Account>) model.get("accountList");
		
		String[] header = {"accNo","accType","accHolderName","openDate","accBalance","branch"};
		csvWriter.writeHeader(header);
		for(Account account : accountList) {
			csvWriter.write(account, header);
		}
		csvWriter.close();
		
		
		
	}

}
