package com.SeleniumPracticeTask18.org;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragandDrop {

	public static void main(String[] args) {

		// Create a new instance of the ChromeDriver that includes WebDriver setup
		WebDriver driver = new ChromeDriver();

		// Maximizes the browser window
		driver.manage().window().maximize();

		// Enter the Valid URL
		driver.get("https://jqueryui.com/droppable/");

		// Switching to the frame where the drag and drop element is located
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);

		// Finding the Drag and Drop elements
		WebElement draggable = driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement droppable = driver.findElement(By.xpath("//div[@id='droppable']"));

		// Create Action class for perform the drag and drop action
		Actions actions = new Actions(driver);
		actions.dragAndDrop(draggable, droppable).build().perform();

		// Verify and print the color value of drop location
		String cssValueColor = droppable.getCssValue("background-color");
		System.out.println("Color value of the target element after drag and drop: " + cssValueColor);

		// Verify that the text has changed to "Dropped" after perform the action
		String dropText = droppable.getText();
		System.out.println("Text of the target element after drop: " + dropText);

		// close the browser
		driver.close();
	}

}
