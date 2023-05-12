package com.coffee.controller;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coffee.model.AddProductModel;
import com.coffee.model.BillModel;
import com.coffee.model.DetailBillModel;
import com.coffee.model.StatusEnum;
import com.coffee.service.BillService;
import com.coffee.service.DetailBillService;
import com.coffee.service.TableService;

@CrossOrigin
@RestController
@RequestMapping("/bill")
public class BillController {
	@Autowired
	BillService billService;

	@Autowired
	TableService tableService;

	@Autowired
	DetailBillService detailBillService;

	@PostMapping("/save/{idTable}")
//	public ResponseEntity<?> insertBill(@RequestBody(required = false) BillModel billModel,
//			@RequestBody(required = false) DetailBillModel deModel, @PathVariable int idTable) {
	public ResponseEntity<?> insertBill(@RequestBody(required = false) AddProductModel adProductModel,
			@PathVariable int idTable) {

		String isUnpaid = billService.isTableUnpaid(StatusEnum.unpaid.toString(), idTable);
		boolean tableExits = tableService.existsTableById(idTable);

		if (tableExits == false) { // kiểm tra bàn có tồn tại không
			return new ResponseEntity<String>("Bạn Chưa chọn bàn hoặc bàn này không tồn tại", HttpStatus.BAD_REQUEST);
		}

		Integer billId = billService.getBillIdByStatusAndTableId(StatusEnum.unpaid.toString(), idTable);

		if (isUnpaid != null && isUnpaid.equals(StatusEnum.unpaid.toString())) { // if isUnpaid # nUll and bill isUnpaid
			// then insert dish in detail bill
			int quantityNew = adProductModel.getDetailBill().getQuantity();
			Integer productId = adProductModel.getDetailBill().getProductId();

			adProductModel.getDetailBill().setBillId(billId);

			int quantity = 0;
			try {
				// kiểm tra khi add sản phẩm mới lần đầu tiên, productid đã tồn tại chưa nếu có
				// thì trả về số lượng
				System.out.println("errr" + productId + billId);
				quantity = detailBillService.exitsProductId(productId, billId);
			} catch (Exception e) {
				System.out.println("kiểm tra sản phẩm có tồn tại trong detailbill lần đầu tiền");
			}

			if (quantity == 0) {
				detailBillService.insertBillDetail(adProductModel.getDetailBill());
				return new ResponseEntity<String>("Thêm món vào detali bill thành công", HttpStatus.NO_CONTENT);

			} else {
				quantity = quantity + quantityNew;
				detailBillService.updateQuantity(quantity, billId, productId);
				return new ResponseEntity<String>("Update số lượng thành công", HttpStatus.NO_CONTENT);
			}

		} else { // first add dish in bill

			LocalDateTime localDateTime = LocalDateTime.now();
			Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
			java.util.Date dateNow = Date.from(instant);

			adProductModel.getBill().setBillStatus(StatusEnum.unpaid.toString());
			adProductModel.getBill().setDateIn(dateNow);
			billService.insertBillToTable(adProductModel.getBill(), idTable); // thêm bill bàn mới

			// thêm detailbill
			billId = billService.getBillIdByStatusAndTableId(StatusEnum.unpaid.toString(), idTable);
			adProductModel.getDetailBill().setQuantity(1);
			adProductModel.getDetailBill().setBillId(billId);

			detailBillService.insertBillDetail(adProductModel.getDetailBill());

			return new ResponseEntity<String>("Thêm Bill va DetailBill Thành công(first add)", HttpStatus.NO_CONTENT);
		}

	}
	
	
	
	@GetMapping("/getBill/{idTable}")
	public ResponseEntity<?> getAllBillTable(@PathVariable int idTable){
		BillModel lst = billService.getBillByTableId(idTable);
		
		return new ResponseEntity<BillModel>(lst, HttpStatus.OK);
	}
}
