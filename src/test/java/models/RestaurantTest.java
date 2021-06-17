package models;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RestaurantTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    public Restaurant setUpNewRestaurant() {
        return new Restaurant("Fish Witch", "214 NE Broadway", "97232", "503-402-9874", "http://fishwitch.com", "hellofishy@fishwitch.com");
    }

    public Restaurant setUpNewALtRestaurant() {
        return new Restaurant("Fish Witch", "214 NE Broadway", "97232", "503-402-9874");
    }

    @Test
    public void restaurant_instantiatesCorrectly_true() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        assertTrue(testRestaurant instanceof Restaurant);
    }

    @Test
    public void getNameReturnsCorrectName() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        assertEquals("Fish Witch", testRestaurant.getName());
    }

    @Test
    public void getAddressReturnsCorrectAddress() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        assertEquals("214 NE Broadway", testRestaurant.getAddress());
    }

    @Test
    public void getZipReturnsCorrectZip() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        assertEquals("97232", testRestaurant.getZipcode());
    }
    @Test
    public void getPhoneReturnsCorrectPhone() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        assertEquals("503-402-9874", testRestaurant.getPhone());
    }

    @Test
    public void getWebsiteReturnsCorrectWebsite() throws Exception {
        Restaurant testRestaurant = setUpNewALtRestaurant();
        assertEquals("no website listed", testRestaurant.getWebsite());
    }

    @Test
    public void getEmailReturnsCorrectEmail() throws Exception {
        Restaurant testRestaurant = setUpNewALtRestaurant();
        assertEquals("no email available", testRestaurant.getEmail());
    }

    @Test
    public void serNameSetsCorrectName() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        testRestaurant.setName("Steak House");
        assertNotEquals("Fish Witch", testRestaurant.getName());
    }

    @Test
    public void setAddressSetsCorrectAddress() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        testRestaurant.setAddress("6600 NE Ainsworth");
        assertNotEquals("214 NE Broadway", testRestaurant.getAddress());
    }

    @Test
    public void setZipSetsCorrectZip() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        testRestaurant.setZipcode("78902");
        assertNotEquals("97232", testRestaurant.getZipcode());
    }
    @Test
    public void setPhoneSetsCorrectPhone() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        testRestaurant.setPhone("971-898-7878");
        assertNotEquals("503-402-9874", testRestaurant.getPhone());
    }

    @Test
    public void setWebsiteSetsCorrectWebsite() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        testRestaurant.setWebsite("http://steakhouse.com");
        assertNotEquals("http://fishwitch.com", testRestaurant.getWebsite());
    }

    @Test
    public void setEmailSetsCorrectEmail() throws Exception {
        Restaurant testRestaurant = setUpNewRestaurant();
        testRestaurant.setEmail("steak@steakhouse.com");
        assertNotEquals("hellofishy@fishwitch.com", testRestaurant.getEmail());
    }

}