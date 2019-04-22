package com.sh.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sh.util.DBConnector;

public class PointDAO { //DB Access   (Data Access Object)
	
	public int  teacherMax() throws Exception{
		PointDTO pointDTO = new PointDTO();
		Connection conn = DBConnector.getConnect();
		
		
		String sql = "select nvl(max(num), 0) num from point";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		rs.next();
		
		int num = rs.getInt("num");
		
		DBConnector.disConnect(st, conn, rs);
		
		return num;
		
	}
	
	public PointDTO num()throws Exception{
		
		PointDTO pointDTO = new PointDTO();
		Connection conn = DBConnector.getConnect();
		
		String sql = "select * from point order by num asc";
		
		PreparedStatement st = conn.prepareStatement(sql);
		
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			pointDTO = new PointDTO();
			pointDTO.setNum(rs.getInt(1));
		}
		
		return pointDTO;
		
	}
	
	
	
	//selectList : 전체 데이터를 리턴
	public ArrayList<PointDTO> selectList() throws Exception{
		//1, 2, 3
		Connection conn = DBConnector.getConnect();
		
		//sql문 작성
		String sql = "select * from point order by num desc";
		
		//미리 전송
		PreparedStatement st = conn.prepareStatement(sql);
		
		//값 세팅 X
		//resultSet
		ResultSet rs = st.executeQuery();
		PointDTO pointDTO = null;
		ArrayList<PointDTO> ar = new ArrayList<PointDTO>();
		while(rs.next()) {
			pointDTO = new PointDTO();
			pointDTO.setNum(rs.getInt(1));
			pointDTO.setSid(rs.getString(2));
			pointDTO.setKor(rs.getInt(3));
			pointDTO.setEng(rs.getInt(4));
			pointDTO.setMath(rs.getInt(5));
			pointDTO.setTotal(rs.getInt(6));
			pointDTO.setAvg(rs.getDouble(7));
			pointDTO.setBnum(rs.getInt(8));
			ar.add(pointDTO);
		}
		
		//연결 끊기
		DBConnector.disConnect(st, conn, rs);
		
		return ar;
	}
	
	//selectOne : 번호를 받아서 해당하는 데이터를 리턴.
	public PointDTO selectOne(int num) throws Exception{
		
		//1, 2, 3,
		Connection conn =  DBConnector.getConnect();
		//4. sql문 작성
		String sql = "select * from point where num = ?";
		//5. 미리 전송
		PreparedStatement st = conn.prepareStatement(sql);
		//6. 값 설정
		st.setInt(1, num);
		//7.
		ResultSet rs = st.executeQuery();
		PointDTO pointDTO = null;   //없으면 이게 리턴되서 null값이 들어간다. 
		if(rs.next()) {
			pointDTO = new PointDTO();
			pointDTO.setNum(rs.getInt(1));
			pointDTO.setSid(rs.getString(2));
			pointDTO.setKor(rs.getInt(3));
			pointDTO.setEng(rs.getInt(4));
			pointDTO.setMath(rs.getInt(5));
			pointDTO.setTotal(rs.getInt(6));	
			pointDTO.setAvg(rs.getDouble(7));
			pointDTO.setBnum(rs.getInt(8));
		}
		
		DBConnector.disConnect(st, conn, rs);
		
		return pointDTO;
	}
	
	//insert
	//접근지정자 그외지정자 리턴타입 메서드명(매개변수){}
	public int insert(PointDTO pointDTO) throws Exception{
		int result = 0;
		
		//1. 4가지 정보 적기
		//2. 드라이버 로딩
		//3. 연결
		Connection conn = DBConnector.getConnect();
		//4. sql문
		String sql = "insert into point values (?, ?, ?, ?, ?, ?, ?, ?)";
		//5. 미리보내기
		PreparedStatement st = conn.prepareStatement(sql);
		//6. ??셋팅
		st.setInt(1, pointDTO.getNum());
		st.setString(2, pointDTO.getSid());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTotal());
		st.setDouble(7, pointDTO.getAvg());
		st.setInt(8, pointDTO.getBnum());
		//7. 최종전송 후 결과 처리
		result = st.executeUpdate();
		//8. 끊기
		
		DBConnector.disConnect(st, conn);
		return result;
	}
	
	//update
	
	//delete
	public int delete(int num) throws Exception {
		int result=0;
		
		//1, 2, 3은 메서드로 연결
		Connection conn = DBConnector.getConnect();
		
		//4. sql문
		String sql = "delete point where num = ? ";  //delete 테이블명 where 조건명;
		
		//5. 미리보내기
		PreparedStatement st = conn.prepareStatement(sql);
		
		//6. ?값 세팅
		
		st.setInt(1, num);
		
		//7. 최종 전송 후 결과 처리
		
		result = st.executeUpdate();
		
		//8.끊어주기
		
		DBConnector.disConnect(st, conn);
		
		
		return result;
	}
	
	
}







