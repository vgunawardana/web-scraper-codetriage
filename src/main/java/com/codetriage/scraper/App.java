package com.codetriage.scraper;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



public class App 
{
    public static void main( String[] args )
    {
        //print title of the web page in the command prompt
    	try {
    		
    		Document doc = Jsoup.connect("https://www.codetriage.com/?language=Java").get();
    		
    		System.out.printf("Title: %s\n", doc.title());
    		
    		//Get the list of repositories
    		Elements repositories = doc.getElementsByClass("repo-item");
    		
    		for(Element repository : repositories) {
    			String repositoryTitle = repository.getElementsByClass("repo-item-title").text();
    			String repositoryIssues = repository.getElementsByClass("repo-item-issues").text();
    			String repositoryDescription = repository.getElementsByClass("repo-item-description").text();
    			String repositoryGitHubName = repository.getElementsByClass("repo-item-full-name").text();
    			
    			String repositoryGitHubLink = "https://github.com/"+repositoryGitHubName.replaceAll("[()]", "");
    			
    			
    			System.out.println(repositoryTitle +" - "+ repositoryIssues);
    			System.out.println("\t"+repositoryDescription);
    			System.out.println("\t"+repositoryGitHubLink);
    			System.out.println("\n");
    			
    		}
    		
    		
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
    }
}
