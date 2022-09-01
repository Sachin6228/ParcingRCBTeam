package demopackage;

import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class ParcingOfRCBTeam 
{

		
		public int OverseasPlayers = 0;
		public int wktkeeper=0;
		JsonPath j;
		
		@BeforeMethod
		public void parsingMethod() 
		{
				
			String jsonBody = "{\r\n"
					+ "  \"name\": \"Royal Challengers Bangalore\",\r\n"
					+ "  \"location\": \"Bangalore\",\r\n"
					+ "  \"player\": [\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Faf Du Plessis\",\r\n"
					+ "      \"country\": \"South Africa\",\r\n"
					+ "      \"role\": \"Batsman\",\r\n"
					+ "      \"price-in-crores\": \"7\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Virat Kohli\",\r\n"
					+ "      \"country\": \"India\",\r\n"
					+ "      \"role\": \"Batsman\",\r\n"
					+ "      \"price-in-crores\": \"15\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Glenn Maxwell\",\r\n"
					+ "      \"country\": \"Australia\",\r\n"
					+ "      \"role\": \"Batsman\",\r\n"
					+ "      \"price-in-crores\": \"11\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Mohammad Siraj\",\r\n"
					+ "      \"country\": \"India\",\r\n"
					+ "      \"role\": \"Bowler\",\r\n"
					+ "      \"price-in-crores\": \"7\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Harshal Patel\",\r\n"
					+ "      \"country\": \"India\",\r\n"
					+ "      \"role\": \"Bowler\",\r\n"
					+ "      \"price-in-crores\": \"10.75\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Wanindu Hasaranga\",\r\n"
					+ "      \"country\": \"Srilanka\",\r\n"
					+ "      \"role\": \"Bowler\",\r\n"
					+ "      \"price-in-crores\": \"10.75\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Dinesh Karthik\",\r\n"
					+ "      \"country\": \"India\",\r\n"
					+ "      \"role\": \"Wicket-keeper\",\r\n"
					+ "      \"price-in-crores\": \"5.5\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Shahbaz Ahmed\",\r\n"
					+ "      \"country\": \"India\",\r\n"
					+ "      \"role\": \"All-Rounder\",\r\n"
					+ "      \"price-in-crores\": \"2.4\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Rajat Patidar\",\r\n"
					+ "      \"country\": \"India\",\r\n"
					+ "      \"role\": \"Batsman\",\r\n"
					+ "      \"price-in-crores\": \"0.20\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Josh Hazlewood\",\r\n"
					+ "      \"country\": \"Australia\",\r\n"
					+ "      \"role\": \"Bowler\",\r\n"
					+ "      \"price-in-crores\": \"7.75\"\r\n"
					+ "    },\r\n"
					+ "    {\r\n"
					+ "      \"name\": \"Mahipal Lomror\",\r\n"
					+ "      \"country\": \"India\",\r\n"
					+ "      \"role\": \"Bowler\",\r\n"
					+ "      \"price-in-crores\": \"7.75\"\r\n"
					+ "    }\r\n"
					+ "  ]\r\n"
					+ "}";
			
			
			
			j= new JsonPath(jsonBody);
			List<Object> list=j.getList("player");
			System.out.println(list.size());		
			
		}
		

		@Test
		public void TC1() 
		{	
			System.out.println("=============TC1 WicketKeeper==============");

			
			List<Object> role=j.getList("player.role");
			System.out.println("Total Players: "+role.size());
			
			
			for(int i=0;i<role.size();i++) 
			{
				if(role.get(i).equals("Wicket-keeper")) 
				{
					
					wktkeeper=wktkeeper+1;			
				}		
			}
			
			System.out.println("Total wicketkeepers: "+wktkeeper);
			
			if (wktkeeper>=1)
			{
			
			System.out.println("Test case 1 Pass");
			
		    }
			
		}

		
		@Test
		public void TC2() 
		{
			System.out.println("============TC2 Overseas Player============");

			List<Object> country =j.getList("player.country");
			System.out.println("Total Countries: "+country.size());
			
			
			for(int i=0;i<country.size();i++) 
			{
				System.out.println(country.get(i));
				if(!country.get(i).equals("India")) 
				{
					OverseasPlayers=OverseasPlayers+1;			
				}		
			}
			
			System.out.println("Overseas Players: "+OverseasPlayers);
			
			if (OverseasPlayers==4)
				{
				
				System.out.println("Test case 2 Passed");
				
			    }		
		}
		

}
