package baseclass;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import genericUtility.DatabaseUtility;
import genericUtility.*;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
	
	public FileUtility fu=new FileUtility();
	public JavaUtility ja=new JavaUtility();
	public DatabaseUtility db=new DatabaseUtility();
	
	public static RequestSpecification request;
	public static ResponseSpecification response;
	
	
	@BeforeSuite
	public void configBS() throws Throwable
	{
		db.getdbConnection();
        System.out.println("=================conect======================");
      RequestSpecBuilder specBuild = new RequestSpecBuilder();
      specBuild.setContentType(ContentType.JSON);
      //specBuild.setAuth(basic("",""));
    //  specBuild.addHeader(DEFAULT_PATH, DEFAULT_BODY_ROOT_PATH);
      specBuild.setBaseUri(fu.getDataProperty("BaseUri"));
      request=specBuild.build();
      
      ResponseSpecBuilder specBuild2 = new ResponseSpecBuilder();
      specBuild2.expectContentType(ContentType.JSON);
      response=specBuild2.build();

      
        
	}
	
	@AfterSuite
	public void configAS()
	{
		db.getCloseConnection();
	        System.out.println("=================ended======================");
			}


}
