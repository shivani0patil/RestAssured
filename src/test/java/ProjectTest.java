

import org.testng.Assert;
import org.testng.annotations.Test;

import Endpoints.IEndpoints;
import baseclass.BaseClass;
import  io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import pojoclass.ProjectPojo;

public class ProjectTest extends BaseClass{
	

	ProjectPojo p;
	
	
	
	@Test
	public void createproject() throws Throwable
	{
		String actualresult="Successfully Added";
		
		String baseUri=fu.getDataProperty("BaseUri");
		
		String projectName="ABC_"+ja.random();
		p=new ProjectPojo(projectName,"Created",0,"dheeray");
		
		
		//precondition 
		
	Response resp=	given()
		.spec(request)
		.body(p)
		
		.when().post(IEndpoints.addProj);
		
		resp.then().log().all()
		.assertThat().statusCode(201);
		
		String expected =resp.jsonPath().get("msg");
		Assert.assertEquals(expected, actualresult);
		
		//database verify
				boolean flag=db.verifyTheData("select * from project",4,projectName);
		Assert.assertTrue(flag,"project verified");
		db.getCloseConnection();
		
		
	}
	
	@Test
	public void createproject1() throws Throwable
	{
		String actualresult="Successfully Added";
		
		String baseUri=fu.getDataProperty("BaseUri");
		
		String projectName="ABC_"+ja.random();
		p=new ProjectPojo(projectName,"Ongoing",0,"dheeray");
		
		
		//precondition 
		
	Response resp=	given()
		.spec(request)
		.body(p)
		
		.when().post(IEndpoints.addProj);
		
		resp.then().log().all()
		.assertThat().statusCode(201);
		
		String expected =resp.jsonPath().get("msg");
		Assert.assertEquals(expected, actualresult);
		
		//database verify
				boolean flag=db.verifyTheData("select * from project",4,projectName);
		Assert.assertTrue(flag,"project verified");
		db.getCloseConnection();
		
		
	}
	
	@Test
	public void createproject2() throws Throwable
	{
		String actualresult="Successfully Added";
		
		String baseUri=fu.getDataProperty("BaseUri");
		
		String projectName="ABC_"+ja.random();
		p=new ProjectPojo(projectName,"Completed",0,"dheeray");
		
		
		//precondition 
		
	Response resp=	given()
		.spec(request)
		.body(p)
		
		.when().post(IEndpoints.addProj);
		
		resp.then().log().all()
		.assertThat().statusCode(201);
		
		String expected =resp.jsonPath().get("msg");
		Assert.assertEquals(expected, actualresult);
		
		//database verify
				boolean flag=db.verifyTheData("select * from project",4,projectName);
		Assert.assertTrue(flag,"project verified");
		db.getCloseConnection();
		
		
	}
	
	
	@Test(dependsOnMethods="createproject2")
	public void conflict2() throws Throwable
	{
      
		
		String baseUri=fu.getDataProperty("BaseUri");
		
		
		
	Response resp=	given()
		.spec(request)
		.body(p)
		
		.when().post(IEndpoints.addProj);
		
		resp.then().log().all()
		.assertThat().statusCode(409);
		
		
		
	}

	


}
