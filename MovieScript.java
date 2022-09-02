package stepdef;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.IMBDPg;
import Pages.WikiPg;
import driver.Common;



public class MovieScript extends Common
{

	String imbdDate=null;
	String imbdCountry=null;
	String wikiDate=null;
	String wikiCountry=null;
	@Test(priority=1)
	public void testIMBD()
	{
		// Load web page
		d.get(imbdURL);
		IMBDPg imd=new IMBDPg(d);
		// Searching movie
		imd.movieSearch("Pushpa:The Rise");
		// Verify release date
		assertTrue(imd.releaseDate.isDisplayed());
		imbdDate=imd.releaseDate.getText();
		// Verify country
		assertTrue(imd.Country.isDisplayed());
		imbdCountry=imd.Country.getText();
			
	}
	@Test(priority=2)
	public void testWiki()
	{
		// Load web page
		d.get(wikiURL);
		WikiPg wiki=new WikiPg(d);
		// Searching movie
		wiki.movieSearch("Pushpa:The Rise");
		// Verify release date
		assertTrue(wiki.releaseDate.isDisplayed());
		wikiDate=wiki.releaseDate.getText();
		System.out.println("Release Date:"+wikiDate);
		// Verify country
		assertTrue(wiki.country.isDisplayed());
		wikiCountry=wiki.country.getText();
			
		
	}
	@Test(priority=3)
	public void testValidateMoviewDetails() throws Exception
	{
		assertEquals(imbdDate,wikiDate);
		assertEquals(imbdCountry,wikiCountry);
		//Thread.sleep(3000);	
				
	}	

}
