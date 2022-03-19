package org.zerock.ex1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.TestPropertySource;
import org.zerock.ex1.entity.Memo;

import javax.transaction.Transactional;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;


@SpringBootTest
public class MemoRepositoryTest {

    private MemoRepository memoRepository;

    @Autowired
    public MemoRepositoryTest(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    @Test
    public void insert() {
        IntStream.rangeClosed(1, 100).forEach(i -> {
            Memo memo = Memo.builder().memoText("sample..." + i).build();
            memoRepository.save(memo);
        });
    }

    @Test
    public void 테스트() {
        long mno = 2L;
        Optional<Memo> result = memoRepository.findById(mno);

        System.out.println("----------");
        if (result.isPresent()) {
            Memo memo = result.get();
            System.out.println(memo);
        }
    }


    @Test
    @Transactional
    public void get원() {
        Long mno = 99L;
        Memo memo = memoRepository.getById(mno);
        System.out.println("-------");
        System.out.println("memo: " + memo);
    }

    @Test
    public void 업데이트() {
        Memo memo = Memo.builder().mno(202L).memoText("새로운 메모").build();
        System.out.println(memo);
        memoRepository.save(memo);
    }

    @Test
    public void 삭제() {
        try {
            memoRepository.deleteById(202L);
        } catch (EmptyResultDataAccessException e) {
            System.out.println(e.getMessage());
            System.out.println("end");
        }
    }

    @Test
    public void 페이징() {
        Pageable pageable = PageRequest.of(39, 5);
        Page<Memo> result = memoRepository.findAll(pageable);
        System.out.println("result : " + result);
        System.out.println("----------");

        System.out.println("result page : " + result.getTotalPages());
        System.out.println("total count : " + result.getTotalElements());
        System.out.println("Page Number : " + result.getNumber());
        System.out.println("Page size : " + result.getSize());
        System.out.println("next page : " + result.hasNext());
        System.out.println("first page : " + result.isFirst());

        List<Memo> content = result.getContent();
        for (Memo m : content) {
            System.out.println("m : " + m);
        }
    }

    @Test
    public void 정렬() {
        Sort mno = Sort.by("mno").descending();
        Pageable pageRequest = PageRequest.of(0, 10, mno);
        Page<Memo> result = memoRepository.findAll(pageRequest);

        result.get().forEach((memo ->
                System.out.println(memo)
        ));
    }

    @Test
    public void 쿼리메서드() {
        List<Memo> byMnoBetweenOrderByMnoDesc = memoRepository.findByMnoBetweenOrderByMnoDesc(70L, 80L);

        for (Memo memo : byMnoBetweenOrderByMnoDesc
        ) {
            System.out.println(memo);
        }
    }

    @Test
    public void 쿼리메서드Pagable() {
        Pageable pageable = PageRequest.of(0, 10, Sort.by("mno").descending());
        Page<Memo> result = memoRepository.findByMnoBetween(10L, 50L, pageable);
        result.get().forEach(memo ->
                System.out.println(memo)
        );
    }

    @Test
    @Commit
    @Transactional
    public void 삭제메서드(){
        memoRepository.deleteMemoByMnoLessThan(1L);
        System.out.println("fail success");
    }

}