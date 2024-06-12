package com.java.logic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProgramType1 {
	public static void main(String[] args) {
		final List<String> PRODUCT_TYPES = Arrays.asList("ACBM","ACDM","ACOM","ACWM","ADSCM","B.Com","BBA",
				 "BBA-BA","C-DMA","C-SEM","C-SEM & DMA","C-SEM & SMM","C-SMM","C-SMM & DMA","CBA","CBA - WX",
				 "CBM","CCC","CDM","CGM","CITM - DB","CITM - ES","CITM - ET","COM","CP-ME","CP-WL","CPBM",
				 "CPM","CWM","DBFM","DBM","DBM - BFL","DBSM","DFM","DFPWM","DGM","DHRM","DITM","DMM","DOM",
				 "DRM","DSCM","DSM","EPBM","IBS","KTN","M.Sc. (AI & ML Ops)","M.Sc. (AI)","M.Sc. (AI) - DL",
				 "M.Sc. (AI) - DO","M.Sc. (App. Fin.)","MBA (BFM)","MBA (BM)","MBA (F)","MBA (FM)","MBA (HR)",
				 "MBA (HRM)","MBA (ITM)","MBA (ITSM)","MBA (M)","MBA (MM)","MBA (ODS)","MBA (OM)","MBA (RM)",
				 "MBA (SCM)","MBA - WX","MBA - X","MFB","MPDV","PC-DM","PC-DS","PCLD","PD - DM","PD - WM",
				 "PD-DS","PDDM","PGDBFM","PGDBM","PGDBM - BFM","PGDBM - FM","PGDBM - HRM","PGDBM - ITM",
				 "PGDBM - ITSM","PGDBM - MM","PGDBM - OM","PGDBM - RM","PGDBM - SCM","PGDFM","PGDGM",
				 "PGDHRM","PGDITM","PGDITSM","PGDMM","PGDMM-MLI","PGDOM","PGDRM","PGDSCM","SSMM");
		
//		String programType = "MBA - WX";
//		String programType = "MBA - X";
//		String programType = "PG";
//		final List<String> finalProgramTypeList = Arrays.asList("MBAWX", "PG", "LEAD", "MBAX", "PDDM");
		
		Map<String, String> productType = new HashMap<>();
		productType.put("MBA - WX", "MBAWX");
		productType.put("MBA - X", "MBAX");
		productType.put("PG", "PG");
		productType.put("PD - DM", "PDDM");
		productType.put("PD - WM", "PDDM");
		productType.put("PD-DS", "PDDM");
		productType.put("PDDM", "PDDM");
		
		String finalProgramType = "";
		String productTypeDao = PRODUCT_TYPES.get(73); // 73 - 76

		System.err.println("PROGRAM_TYPES: " + productTypeDao);
		
		if (productType.containsKey(productTypeDao)) {
			System.err.println("PRODUCT TYPE: " + productType.get(productTypeDao));
		} else {
			System.err.println("PRODUCT TYPE: " + "PG");
		}

		System.err.println("FINAL PROGRAM TYPE: " + finalProgramType);
	}
}
