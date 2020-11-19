package hiberApp;

import util.HiberUtil;
import org.hibernate.SessionFactory;

/**
 @author Brijesh
 @version 1.0
 */
public final class MainApp {

    private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.XML);

    public static void main(String[] args) {

        //--------Load Data------
          final DataLoad dataLoad = new DataLoad();
          dataLoad.createData(SESSION_FACTORY);

          //----Query JPQL------

//        final DataQueries dataQueries = new DataQueries();

//        dataQueries.showAllStudent(SESSION_FACTORY);
//        dataQueries.showAllStudent(SESSION_FACTORY);
//        dataQueries.showGroupByTest(SESSION_FACTORY);
//        dataQueries.showImplicitJoinOnPersonsAddresses(SESSION_FACTORY);
//        dataQueries.showExplicitJoinOnTeachersSubjects(SESSION_FACTORY);
    }
}
