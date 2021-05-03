/* �귣ġ ���� : daoBran
 * Mybatis���� ����
 * 0. SqlSessionFactoryBulider : ���� ���� �о SqlSessionFactory ����� ����
 * 1. SqlSessionFactory ���� : Mybatis�� Sql������ �����ϴ� ��ü,SqlSession�� ����� ����
 * 2. SqlSession ����(���� ���ǹ�����) : �����ͺ��̽� ���ǹ��� Ȱ���ϱ����� Ŭ���� ����
 *    - selectList() 
 *    - selectOne()
 *    - insert()
 *    - update()
 *    - delete()
 * 
 * ���̹�Ƽ���� �ҷ��� ���ǹ��� �����ϴ°�
 * ��ü��ȸ, ������ȸ, ���߰�, �����, �����
 */
package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import model.Book;

public class BookDAO {
	// �ʵ�
	private SqlSessionFactory sqlSessionFactory = null;
	//�����ڿ� sqlSessionFactory�� ����
	public BookDAO(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	// å(Book)�� ��ü��ȸ
	public List<Book> selectAll() {
		List<Book> list = null;  // ��ü��ȸ�� ����Ʈ����

		// ���ǹ� ����
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




