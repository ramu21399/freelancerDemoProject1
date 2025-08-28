package com.freelancer.dto;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@JsonPropertyOrder({ "bookId", "title", "author", "price" })
public class BookDto {
	@Id
	@Schema(description = "Book ID", accessMode = Schema.AccessMode.READ_ONLY)
	private Long bookId;
	@NonNull
	@NotBlank(message = "title shoud not null ")
	private String title;
	@NonNull
	private String author;
	@NonNull
	private Double price;

}
