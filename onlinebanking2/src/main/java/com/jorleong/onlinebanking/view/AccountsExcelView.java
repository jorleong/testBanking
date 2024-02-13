package com.jorleong.onlinebanking.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;


import com.jorleong.onlinebanking.domain.Account;

public class AccountsExcelView extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		Sheet sheet = workbook.createSheet("List of Accounts");
		List<Account> accountList = (List<Account>) model.get("accountList");
		
		Row row = null;
		Cell cell = null;
		int r = 0;
		int c = 0;
		
		row = sheet.createRow(r++);
		cell = row.createCell(c++);
		cell.setCellValue("accNo");
		
		cell = row.createCell(c++);
		cell.setCellValue("accType");
		
		cell = row.createCell(c++);
		cell.setCellValue("accHolderName");
		
		cell = row.createCell(c++);
		cell.setCellValue("openDate");
		
		cell = row.createCell(c++);
		cell.setCellValue("accBalance");
		
		cell = row.createCell(c++);
		cell.setCellValue("branch");
		
		for(Account account : accountList) {
			row = sheet.createRow(r++);
			c = 0;
			row.createCell(c++).setCellValue(account.getAccNo());
			row.createCell(c++).setCellValue(account.getAccType());
			row.createCell(c++).setCellValue(account.getAccHolderName());
			row.createCell(c++).setCellValue(account.getOpenDate().toLocaleString());
			row.createCell(c++).setCellValue(account.getAccBalance());
			row.createCell(c++).setCellValue(account.getBranch().getbCode());
		}
		
		
	}

}
