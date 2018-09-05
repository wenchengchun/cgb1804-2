package com.poi.testpoi.service;

import com.poi.testpoi.common.MyException;
import com.poi.testpoi.mapper.HousesrcMapper;
import com.poi.testpoi.pojo.Housesrc;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class HousesrcServiceImpl implements HousesrcService {


	@Autowired
	private HousesrcMapper housesrcMapper;


	@Override
	public List<Housesrc> selectHousesrcs() {
		return housesrcMapper.selectHousesrcs();
	}


	@Transactional(readOnly = false,rollbackFor = Exception.class)
	@Override
	public boolean batchImport(String fileName, MultipartFile file) throws Exception {
		boolean notNull = false;
		List<Housesrc> housesrcList = new ArrayList<>();
		if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
			throw new MyException("上传文件格式不正确");
		}
		boolean isExcel2003 = true;
		if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
			isExcel2003 = false;
		}
		InputStream is = file.getInputStream();
		Workbook wb = null;
		if (isExcel2003) {
			wb = new HSSFWorkbook(is);
		} else {
			wb = new XSSFWorkbook(is);
		}
		Sheet sheet = wb.getSheetAt(0);
		if(sheet!=null){
			notNull = true;
		}
		Housesrc housesrc;
		for (int r = 2; r <= sheet.getLastRowNum(); r++) {//r = 2 表示从第三行开始循环 如果你的第三行开始是数据
			Row row = sheet.getRow(r);//通过sheet表单对象得到 行对象
			if (row == null){
				continue;
			}

			//sheet.getLastRowNum() 的值是 10，所以Excel表中的数据至少是10条；不然报错 NullPointerException

			housesrc = new Housesrc();

			if( row.getCell(0).getCellType() !=1){//循环时，得到每一行的单元格进行判断
				throw new MyException("导入失败(第"+(r+1)+"行,用户名请设为文本格式)");
			}
			


			row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第1个单元格的值
			String title = row.getCell(1).getStringCellValue();
			if(title==null || title.isEmpty()){
				throw new MyException("导入失败(第"+(r+1)+"行,title未填写)");
			}
			
			row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第2个单元格的值
			Double price = row.getCell(1).getNumericCellValue();
			if(price==null || price.isNaN()){
				throw new MyException("导入失败(第"+(r+1)+"行,price未填写)");
			}
			
			row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第3个单元格的值
			Double are = row.getCell(1).getNumericCellValue();
			if(are==null || are.isNaN()){
				throw new MyException("导入失败(第"+(r+1)+"行,are未填写)");
			}
			
			
			row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第4个单元格的值
			String modle = row.getCell(1).getStringCellValue();
			if(modle==null || modle.isEmpty()){
				throw new MyException("导入失败(第"+(r+1)+"行,modle未填写)");
			}
			
			row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第5个单元格的值
			String hight = row.getCell(1).getStringCellValue();
			if(hight==null || hight.isEmpty()){
				throw new MyException("导入失败(第"+(r+1)+"行,hight未填写)");
			}
			
			row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第6个单元格的值
			String bear = row.getCell(1).getStringCellValue();
			if(bear==null || bear.isEmpty()){
				throw new MyException("导入失败(第"+(r+1)+"行,bear未填写)");
			}
			
			row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第7个单元格的值
			String sub = row.getCell(1).getStringCellValue();
			if(sub==null || sub.isEmpty()){
				throw new MyException("导入失败(第"+(r+1)+"行,sub未填写)");
			}
			
			row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第8个单元格的值
			String str = row.getCell(1).getStringCellValue();
			if(str==null || str.isEmpty()){
				throw new MyException("导入失败(第"+(r+1)+"行,str未填写)");
			}
			
			row.getCell(8).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第9个单元格的值
			String loc = row.getCell(1).getStringCellValue();
			if(loc==null || loc.isEmpty()){
				throw new MyException("导入失败(第"+(r+1)+"行,loc未填写)");
			}
			
			row.getCell(9).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第10个单元格的值
			String tim = row.getCell(1).getStringCellValue();
			if(tim==null || tim.isEmpty()){
				throw new MyException("导入失败(第"+(r+1)+"行,tim未填写)");
			}
			
			row.getCell(10).setCellType(Cell.CELL_TYPE_STRING);//得到每一行的 第11个单元格的值
			String url = row.getCell(1).getStringCellValue();
			if(url==null || url.isEmpty()){
				throw new MyException("导入失败(第"+(r+1)+"行,url未填写)");
			}
			//完整的循环一次 就组成了一个对象
			housesrc.setTitle(title);
			housesrc.setPrice(price);
			housesrc.setAre(are);
			housesrc.setModle(modle);
			housesrc.setHight(hight);
			housesrc.setBear(bear);
			housesrc.setSub(sub);
			housesrc.setStr(str);
			housesrc.setLoc(loc);
			housesrc.setTim(tim);
			housesrc.setUrl(url);
			housesrcList.add(housesrc);
		}
		for (Housesrc housesrcResord : housesrcList) {
			String title = housesrcResord.getTitle();
			int cnt = housesrcMapper.selectByTitle(title);
			if (cnt == 0) {
				housesrcMapper.addHousesrc(housesrcResord);
				System.out.println(" 插入 "+housesrcResord);
			} else {
				housesrcMapper.updateHousesrcByName(housesrcResord);
				System.out.println(" 更新 "+housesrcResord);
			}
		}
		return notNull;
	}

}
