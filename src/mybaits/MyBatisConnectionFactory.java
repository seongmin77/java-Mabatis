/*
 * 1) SqlSessionFactoryBulider
 * - 설정 정보 읽어서 SqlSessionFactory 만드는 역할
 * - DataSource에 대한 환경설정을 불러들인다.
 */
package mybaits;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisConnectionFactory {
	private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            String resource = "config/config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
 
			if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
