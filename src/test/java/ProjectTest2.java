import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import Endpoints.IEndpoints;
import baseclass.BaseClass;
import io.restassured.response.Response;
import pojoclass.ProjectPojo;

public class ProjectTest2 extends BaseClass {

	
	ProjectPojo p;
	
	@Test
	public void conflict2() throws Throwable
	{
		String ProjectId="NH_PROJ_8641";
		String actualresult="The Project Name : Already Exists";
		
		String baseUri=fu.getDataProperty("BaseUri");
		
		//String projectName="ABC_"+ja.random();
		p=new ProjectPojo("","Created",0,"dheeray");
		
		
		//precondition 
		
	Response resp=	given()
		.spec(request)
		.body(p)
		
		.when().post(IEndpoints.addProj);
		
		resp.then().log().all()
		.assertThat().statusCode(409);
		
		String expected =resp.jsonPath().get("message");
		Assert.assertEquals(expected, actualresult);
		
		//database verify
				boolean flag=db.verifyTheData("select * from project",0,ProjectId);
		Assert.assertTrue(flag,"project verified");
		db.getCloseConnection();
//		
		
	}
	
	
}
