package org.zerock.sample;

// @RequiredArgsConstructor에서 우클릭 - Refactor - Delombok을 하면, 아래와 같은 코드가 됨
/*
 * public class SampleHotel {
 *     private Chef chef;        // 멤버 변수(member variable)
 *
 *     public SampleHotel() {    // 생성자(constructor)
 *     }
 * }
 * */

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*@AllArgsConstructor
public class SampleHotel {
    private Chef chef;      // 멤버 변수(member variable)

//    아래는 @AllArgsConstructor를 붙이지 않고 사용했을 때와 같은 의미이다.
//    @AllArgsConstructor 상태에서
//    public SampleHotel(Chef chef, String test1) {  // 생성자(constructor)
//        this.chef = chef;
//    }
}*/

@Component  // 반드시 @Component 해야함 => Lombok으로 Bean 관리
@ToString
@Getter
@RequiredArgsConstructor    // final 변수이거나 NonNull 지정된 변수
public class SampleHotel {
    @NonNull
    private Chef chef;      // 멤버 변수(member variable)
//    private final String test1;
//    private String test2;
    @Autowired
    private Restaurant restaurant;

    // @RequiredArgsConstructor 상태에서 우클릭-Refactor-Delombok 하면 아래의 코드가 추가됨(@RequiredArgsConstructor는 사라짐)
    /* public SampleHotel(@NonNull Chef chef, String test1) {
     *       this.chef = chef;
     *       this.test1 = test1;
     * }
     * */
}