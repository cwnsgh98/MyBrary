package com.mybrary.backend.domain.book.repository.custom;

import com.mybrary.backend.domain.book.dto.BookGetDto;
import java.util.List;
import java.util.Optional;

public interface BookRepositoryCustom {


    Optional<Integer> countMyBook(Long bookShelfId);

    List<BookGetDto> getAllBookByCategoryId(Long categoryId);
}
