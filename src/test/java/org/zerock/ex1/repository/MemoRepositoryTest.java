package org.zerock.ex1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.ex1.entity.Memo;

import javax.transaction.Transactional;
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
    public void get원(){
        Long mno = 99L;
        Memo memo = memoRepository.getById(mno);
        System.out.println("-------");
        System.out.println("memo: " +memo);
    }
}