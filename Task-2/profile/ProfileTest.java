package ir.freeland.spring.profile.datasource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class ProfileTest implements DatasourceConfig {
	

	@Value("${spring.datasource.url}")
	private String driver;
	
    @Override
    public void setup() {
        System.out.println("Setting up datasource for testProfile environment. Driver is: " + driver );

    }

}
