package twonyizin.springframework;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import twonyizin.springframework.controllers.MyController;
import twonyizin.springframework.examplebeans.FakeDataSource;
import twonyizin.springframework.examplebeans.FakeJmsBroker;

@SpringBootApplication
public class DiDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(DiDemoApplication.class,args);
        MyController controller = (MyController) ctx.getBean("myController");
        FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean(FakeDataSource.class);

        System.err.println(fakeDataSource.getUser());

        FakeJmsBroker fakeJmsBroker = (FakeJmsBroker) ctx.getBean(FakeJmsBroker.class);
        System.err.println(fakeJmsBroker.getUser());
    }

}
