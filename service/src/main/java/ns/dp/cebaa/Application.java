package ns.dp.cebaa;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {
	private static ApplicationContext ctx;
    public static void main(String[] args) {
        ctx = SpringApplication.run(Application.class, args);
    }
    
    public static void close(){
    	if(ctx!=null){
    		SpringApplication.exit(ctx, new ExitCodeGenerator(){

				@Override
				public int getExitCode() {
					return 0;
				}
    			
    		});
    	}
    }
}