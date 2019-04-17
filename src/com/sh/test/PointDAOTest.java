package com.sh.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.Test;

import com.sh.point.PointDAO;
import com.sh.point.PointDTO;
import com.sh.util.DBConnector;

public class PointDAOTest {
	
	
	@Test
	public void selectListTest() throws Exception{
		PointDAO pointDAO = new PointDAO();
		ArrayList<PointDTO> ar  = pointDAO.selectList();
		assertNotEquals(0, ar.size());   // 0이면 하나도 안꺼내온 것이고 이상이면 꺼낸것
	}
	
	
	@Test
	public void selectTest() throws Exception {
		PointDAO pointDAO = new PointDAO();
		PointDTO pointDto = pointDAO.selectOne(1);
		assertNotNull(pointDto);
		
		
	}
	
	
	@Test
	public void deleteTest() throws Exception{
		PointDAO pointDAO = new PointDAO();
		int result = pointDAO.delete(1);  //1개가 지워졌으면 1이 오고 지우지 못하면 0이 들어온다. 
		assertEquals(1, result);
		
		
	}

	@Test
	public void test() throws Exception{
		
		PointDAO pointDAO = new PointDAO();
		PointDTO pointDTO = new PointDTO();
		pointDTO.setNum(1);
		
		pointDTO.setSid("iu");
		pointDTO.setKor(20);

		int result = pointDAO.insert(pointDTO);
		assertEquals(1, result);

	}

}
