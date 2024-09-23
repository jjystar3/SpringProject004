package com.example.demo.domain;

import java.util.List;

import org.junit.jupiter.api.Test;

public class MemberRepositoryTest {

	// 스프링을 사용하지 않았기 때문에 직접 리파지토리 객체 생성해야함
	MemberRepository repository = new MemberRepository();
	
	@Test
	public void test() {
		
		// 1.회원 등록 (2명)
		Member member1 = Member
				.builder()
				.userId("user1")
				.password("1234")
				.build();

		Member member2 = Member
				.builder()
				.userId("user2")
				.password("1234")
				.build();
		
		repository.save(member1);
		repository.save(member2);
		
		// 2.회원 목록 조회
		List<Member> list = repository.findAll();
		System.out.println("회원 목록:");
		for(Member member : list) {
			System.out.println(member);
		}
		
		// 3.1번째 회원 조회
		System.out.println("1번째 회원 목록: " + repository.findById(1));
		
		// 4.모든 회원 삭제
		repository.clearStore();

		List<Member> list2 = repository.findAll();
		System.out.println("삭제 후 회원 목록:");
		for(Member member : list2) {
			System.out.println(member);
		}
	}
	
}
