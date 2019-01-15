package com.framgia.hepler;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.framgia.bean.OrderInfo;

public class ExportListOrderToExcel extends AbstractXlsView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.setHeader("Content-Disposition", "attachment;filename=\"student.xls\"");
		List<OrderInfo> orders = (List<OrderInfo>) model.get("orders");
		Sheet sheet = workbook.createSheet("List Order");
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("ID");
		header.createCell(1).setCellValue("Customer Name");
		header.createCell(2).setCellValue("Total bill");

		int rowNum = 1;
		for (OrderInfo orderInfo : orders) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(orderInfo.getId());
			row.createCell(1).setCellValue(orderInfo.getUser().getName());
			row.createCell(2).setCellValue(orderInfo.getTotalBill());
		}
	}
}
