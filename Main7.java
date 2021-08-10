package com.koreait.crawling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main7 {
	public static void main(String[] args) {
		String DRIVER_ID = "webdriver.chrome.driver";
		String DRIVER_PATH = "C:/Users/이예솔/Desktop/새 폴더/JSP/chromedriver.exe";

		System.setProperty(DRIVER_ID, DRIVER_PATH);
		WebDriver driver = new ChromeDriver();

		String base_url = "https://www.banapresso.com/store";

		try {
			driver.get(base_url);
			int i = 2;

			while (true) {
				// 읽어오고 싶은 부분
				List<WebElement> elements = driver.findElements(By.className("store_name_map"));
				for (WebElement el : elements) {
					Thread.sleep(1000);
					String[] arr = el.getText().split("\n");
					System.out.println("지점 : "+arr[1]);
					System.out.println("주소 : "+arr[2]);
					System.out.println("=================================");
					
				}
				if (i == 6) {
					try {
						List<WebElement> Btns = driver.findElements(By.cssSelector("div.pagination > span > a"));
						for (WebElement el : Btns) {
							if (el.getText().equals("다음")) {
								el.click();
								i = 2;
								break;
							}
						}

					} catch (Exception e) {
						break;
					}
				} else {
					WebElement Nextpage = driver
							.findElement(By.cssSelector("div.pagination > ul > li:nth-child(" + i + ") > a"));
					Nextpage.click();
					i++;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("출력 끝");
		}
	}
}
