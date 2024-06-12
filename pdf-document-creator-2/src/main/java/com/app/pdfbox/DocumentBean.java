package com.app.pdfbox;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentBean implements Serializable {

	private String title;
	private String version;
	private String referenceId;
}
