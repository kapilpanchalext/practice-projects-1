package com.app.hooks.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.hooks.model.Image;
import com.app.hooks.model.PlacesBean;

@Repository
public class ReactCustomHooksDao {

	public List<PlacesBean> placesBean = new ArrayList<>();

	public ReactCustomHooksDao() {
		PlacesBean place1 = PlacesBean.builder().id("p1").title("Forest Waterfall")
				.image(Image.builder().src("forest-waterfall.jpg")
						.alt("A tranquil forest with a cascading waterfall amidst greenery.").build())
				.lat(44.5588).lon(-80.344).build();

		PlacesBean place2 = PlacesBean.builder().id("p2").title("Sahara Desert Dunes")
				.image(Image.builder().src("desert-dunes.jpg")
						.alt("Golden dunes stretching to the horizon in the Sahara Desert.").build())
				.lat(25.0).lon(0.0).build();

		PlacesBean place3 = PlacesBean.builder().id("p3").title("Himalayan Peaks")
				.image(Image.builder().src("majestic-mountains.jpg")
						.alt("The sun setting behind snow-capped peaks of majestic mountains.").build())
				.lat(27.9881).lon(86.925).build();

		PlacesBean place4 = PlacesBean.builder().id("p4").title("Caribbean Beach")
				.image(Image.builder().src("caribbean-beach.jpg")
						.alt("Pristine white sand and turquoise waters of a Caribbean beach.").build())
				.lat(18.2208).lon(-66.5901).build();

		PlacesBean place5 = PlacesBean.builder().id("p5").title("Ancient Grecian Ruins")
				.image(Image.builder().src("ruins.jpg")
						.alt("Historic ruins standing tall against the backdrop of the Grecian sky.").build())
				.lat(37.9715).lon(23.7257).build();

		PlacesBean place6 = PlacesBean
				.builder().id("p6").title("Amazon Rainforest Canopy").image(Image.builder().src("rainforest.jpg")
						.alt("Lush canopy of a rainforest, teeming with life.").build())
				.lat(-3.4653).lon(-62.2159).build();

		PlacesBean place7 = PlacesBean.builder().id("p7").title("Northern Lights")
				.image(Image.builder().src("northern-lights.jpg")
						.alt("Dazzling display of the Northern Lights in a starry sky.").build())
				.lat(64.9631).lon(-19.0208).build();

		PlacesBean place8 = PlacesBean.builder().id("p8").title("Japanese Temple")
				.image(Image.builder().src("japanese-temple.jpg")
						.alt("Ancient Japanese temple surrounded by autumn foliage.").build())
				.lat(34.9949).lon(135.785).build();

		PlacesBean place9 = PlacesBean.builder().id("p9").title("Great Barrier Reef")
				.image(Image.builder().src("great-barrier-reef.jpg")
						.alt("Vibrant coral formations of the Great Barrier Reef underwater.").build())
				.lat(-18.2871).lon(147.6992).build();

		PlacesBean place10 = PlacesBean.builder().id("p10").title("Parisian Streets")
				.image(Image.builder().src("parisian-streets.jpg")
						.alt("Charming streets of Paris with historic buildings and cafes.").build())
				.lat(-18.2871).lon(147.6992).build();

		PlacesBean place11 = PlacesBean.builder().id("p11").title("Grand Canyon")
				.image(Image.builder().src("grand-canyon.jpg")
						.alt("Expansive view of the deep gorges and ridges of the Grand Canyon.").build())
				.lat(36.1069).lon(-112.1129).build();

		PlacesBean place12 = PlacesBean.builder().id("p12").title("Venetian Canals")
				.image(Image.builder().src("venetian-canals.jpg")
						.alt("Glistening waters of the Venetian canals as gondolas glide by at sunset.").build())
				.lat(45.4408).lon(12.3155).build();

		PlacesBean place13 = PlacesBean.builder().id("p13").title("Taj Mahal")
				.image(Image.builder().src("taj-mahal.jpg")
						.alt("The iconic Taj Mahal reflecting in its surrounding waters during sunrise.").build())
				.lat(27.1751).lon(78.0421).build();

		PlacesBean place14 = PlacesBean.builder().id("p14").title("Kerala Backwaters")
				.image(Image.builder().src("kerala-backwaters.jpg")
						.alt("Tranquil waters and lush greenery of the Kerala backwaters.").build())
				.lat(9.4981).lon(76.3388).build();

		PlacesBean place15 = PlacesBean.builder().id("p15").title("African Savanna")
				.image(Image.builder().src("african-savanna.jpg")
						.alt("Wild animals roaming freely in the vast landscapes of the African savanna.").build())
				.lat(-2.153).lon(34.6857).build();

		PlacesBean place16 = PlacesBean.builder().id("p16").title("Victoria Falls")
				.image(Image.builder().src("victoria-falls.jpg")
						.alt("The powerful cascade of Victoria Falls, a natural wonder between Zambia and Zimbabwe.")
						.build())
				.lat(-17.9243).lon(25.8572).build();

		PlacesBean place17 = PlacesBean.builder().id("p17").title("Machu Picchu")
				.image(Image.builder().src("machu-picchu.jpg")
						.alt("The historic Incan citadel of Machu Picchu illuminated by the morning sun.").build())
				.lat(-13.1631).lon(-72.545).build();

		PlacesBean place18 = PlacesBean.builder().id("p18").title("Amazon River")
				.image(Image.builder().src("amazon-river.jpg")
						.alt("Navigating the waters of the Amazon River, surrounded by dense rainforest.").build())
				.lat(-3.4653).lon(-58.38).build();

		placesBean.addAll(List.of(place1, place2, place3, place4, place5, place6, place7, place8, place9, place10,
				place11, place12, place13, place14, place15, place16, place17, place18));

	
	}
	
	public List<PlacesBean> getPlacesList() {
		return placesBean;
	}
}
