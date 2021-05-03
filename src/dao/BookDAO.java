/* 브랜치 생성 : daoBran
 * Mybatis사용시 순서
 * 0. SqlSessionFactoryBulider : 설정 정보 읽어서 SqlSessionFactory 만드는 역할
 * 1. SqlSessionFactory 생성 : Mybatis와 Sql서버를 연결하는 객체,SqlSession을 만드는 역할
 * 2. SqlSession 생성(실제 질의문실행) : 데이터베이스 질의문을 활용하기위한 클래스 생성
 *    - selectList() 
 *    - selectOne()
 *    - insert()
 *    - update()
 *    - delete()
 * 
 * 마이바티스를 불러서 질의문을 실행하는곳
 * 전체조회, 선택조회, 행추가, 행수정, 행삭제
 */
package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Book;

public class BookDAO {
	// 필드
	private SqlSessionFactory sqlSessionFactory = null;
	//생성자에 sqlSessionFactory를 생성
	public BookDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	// 책(Book)의 전체조회
	public List<Book> selectAll() {
		List<Book> list = null;  // 전체조회시 리스트보관

		// 질의문 실행
		SqlSession session = sqlSessionFactory.openSession();
		
        try {
            list = session.selectList("Book.selectAll");
            //            .selectList(namespace+".id");
        } finally {
            session.close();
        }
		return list;
	}
	   public Book selectById(int id){
	        Book book = null;
	        SqlSession session = sqlSessionFactory.openSession();
	        try {
	            book = session.selectOne("Book.selectById", id);
	        } finally {
	            session.close();
	        }
	 
	        return book;
	    }
	 
	    public int insert(Book book){
	        int id = -1;
	        SqlSession session = sqlSessionFactory.openSession();
	 
	        try {
	            id = session.insert("Book.insert", book);
	        } finally {
	            session.commit();
	            session.close();
	        }
	 
	        return id;
	    }
	 
	    public void update(Book book){
	 
	        SqlSession session = sqlSessionFactory.openSession();
	 
	        try {
	            session.update("Book.update", book);
	        } finally {
	            session.commit();
	            session.close();
	        }
	    }
	 
	    /**
	     * Delete an instance of book from the database.
	     * @param id value of the instance to be deleted.
	     */
	    public void delete(int id){
	 
	        SqlSession session = sqlSessionFactory.openSession();
	 
	        try {
	            session.delete("Book.delete", id);
	        } finally {
	            session.commit();
	            session.close();
	        }
	    }
	
	
}




