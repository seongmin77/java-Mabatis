/* ������ �ø���222
 * test git
 * 
 */
import java.util.List;

import dao.BookDAO;
import model.Book;
import mybaits.MyBatisConnectionFactory;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BookDAO bookDAO = new BookDAO(MyBatisConnectionFactory.getSqlSessionFactory());
		 
        Book book = new Book();
 
        //Creat
        //2���� �Է��Ѵ�.
        System.out.println("==INSERT==");
 
        book.setId(1);
        book.setName("ȫ�浿��");
        bookDAO.insert(book);
 
        book.setId(2);
        book.setName("���������"); 
        bookDAO.insert(book);
 
        //Read
        //�Է��� ����Ʈ�� �����ش�.
        List<Book> bookList = bookDAO.selectAll();
        for(Book bookInfo: bookList){
            System.out.println("BOOK ID: "+bookInfo.getId());
            System.out.println("BOOK NAME: "+bookInfo.getName());
        }
 
        //Update
        System.out.println("");
        System.out.println("==UPDATE==");
 
        //ID 2���� �̸��� ������Ʈ �Ѵ�.
        book.setId(2);
        book.setName("���� 2����");
        bookDAO.update(book);
 
        //Read
        //������ ID 2���� �̸��� �����ش٤�.
        book = bookDAO.selectById(2);
        System.out.println("BOOK ID: "+book.getId());
        System.out.println("BOOK NAME: "+book.getName());
 
        //Delete
        System.out.println("");
        System.out.println("==DELETE==");
 
        //2���� �����Ѵ�.
        bookDAO.delete(2);
 
        //Read
        //��ü ����Ʈ�� �����ش�.
        bookList.clear();
        bookList = bookDAO.selectAll();
        for(Book bookInfo: bookList){
            System.out.println("BOOK ID: "+bookInfo.getId());
            System.out.println("BOOK NAME: "+bookInfo.getName());
        }
		
		// ��ü��ȸ
		
	
	}

}
