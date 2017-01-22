package com.davis.design_pattern.behavioral.Observer.exam002;

import com.davis.design_pattern.behavioral.Observer.exam002.observable.News;
import com.davis.design_pattern.behavioral.Observer.exam002.observer.Reader;

public class RunMain {

	public static void main(String[] args) {
		News news = new News();

		Reader john = new Reader("john"); // 新增讀者
		Reader mary = new Reader("mary");
		Reader bill = new Reader("bill");

		// Observer(Reader)訂閱Observable(News)
		john.subscribe(news); // 訂閱新聞
		mary.subscribe(news);
		bill.subscribe(news);

		news.setLatestNews(true); // 更改Observble(News)的狀態

	}
}
