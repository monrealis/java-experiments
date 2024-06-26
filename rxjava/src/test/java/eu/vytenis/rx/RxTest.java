package eu.vytenis.rx;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableEmitter;
import io.reactivex.rxjava3.core.ObservableOnSubscribe;
import io.reactivex.rxjava3.functions.Consumer;

public class RxTest {
	@Test
	public void run() {
		Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
			public void subscribe(ObservableEmitter<Integer> emitter) {
				for (int i = 0; i < 5; ++i) {
					System.out.println("Before publish: " + i);
					emitter.onNext(i);
					System.out.println("After publish: " + i);
				}
			};
		});
		observable.subscribe(new Consumer<Integer>() {
			public void accept(Integer n) {
				System.out.println("Received: " + n);
			}
		});
		observable.subscribe(new Consumer<Integer>() {
			public void accept(Integer n) {
				System.out.println("Received again: " + n);
			}
		});
	}

	@Test
	public void scan() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		Observable.fromIterable(list).scan(Integer::sum).subscribe(System.out::println);
	}
}
