package com.itacademy.apiTests;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import java.io.File;


import static io.restassured.RestAssured.given;

public class ApiTests {

    @Test
    public void getOpenWishlistPageTest(){
        given().log().all()
                .when().get("https://maps.googleapis.com/maps/api/mapsjs/gen_204?csp_test=true")
                .then().log().all().statusCode(200);
    }
    @Test
    public void putUpdateProfileWithoutCookieTest(){
        File file = new File("src/test/resources/json/jsonFile.json");
        given().log().all().contentType(ContentType.JSON)
                .body(file)
                .when().put("https://jysk.co.uk/wss/json/v2/data/customer/save")
                .then().log().body().statusCode(401);
    }
    @Test
    public void putUpdateProfileWithCookieTest(){
        File file = new File("src/test/resources/json/jsonFile.json");
        given().cookie("_dy_c_exps=; _dycnst=dg; _dyid=-2751698421416183836; _dy_geo=BY.EU.BY_HM.BY_HM_Minsk; _dy_df_geo=Belarus..Minsk; _dy_soct=; CookieInformationConsent=%7B%22website_uuid%22%3A%22edff3818-f291-4e5e-9dcc-d4ec01445083%22%2C%22timestamp%22%3A%222024-07-02T17%3A42%3A11.627Z%22%2C%22consent_url%22%3A%22https%3A%2F%2Fjysk.co.uk%2Fcustomer%2Ffavourites%22%2C%22consent_website%22%3A%22jysk.co.uk%22%2C%22consent_domain%22%3A%22jysk.co.uk%22%2C%22user_uid%22%3A%221a8d9e94-b755-4a00-8ec0-8a14c57db3fa%22%2C%22consents_approved%22%3A%5B%22cookie_cat_necessary%22%5D%2C%22consents_denied%22%3A%5B%22cookie_cat_functional%22%2C%22cookie_cat_statistic%22%2C%22cookie_cat_marketing%22%2C%22cookie_cat_unclassified%22%5D%2C%22user_agent%22%3A%22Mozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F126.0.0.0%20Safari%2F537.36%22%7D; _dy_csc_ses=t; _dyjsession=445c66b19b286665bfeafbb93abe6720; dy_fs_page=jysk.co.uk; _dycst=dk.w.c.ws.; sc-lead-generation-disabled=true; X-Mapping-hnbgcfhb=9033E07AB51BE78478E94C546300DCED; JSESSIONID=9634CA6254BA66B183FA9D57451DA14B; WSS_CUSTOMER_SESSION_UUID=bedb74eb-0a2d-4336-b606-3bff6273121e; _dy_ses_load_seq=22819%3A1720193862488; _dy_lu_ses=445c66b19b286665bfeafbb93abe6720%3A1720193867114; _dy_toffset=-5")
                .log().all().contentType(ContentType.JSON)
                .body(file)
                .when().put("https://jysk.co.uk/wss/json/v2/data/customer/save")
                .then().log().body().statusCode(200);
    }
    @Test
    public void postCustomServiceTest(){
        File file = new File("src/test/resources/json/jsonFileForPost.json");
        given().log().all().contentType(ContentType.JSON)
                .body(file)
                .when().post("https://careers.jysk.co.uk/?utm_source=jysk.co.uk&utm_medium=referral&utm_campaign=job-button-top-navigation")
                .then().log().all().statusCode(200);
    }
    @Test
    public void postProductToTheWishlistTest(){
                File file = new File("src/test/resources/json/productForDelete.json");
        given().cookie("_dy_c_exps=; _dycnst=dg; _dyid=-2751698421416183836; _dy_geo=BY.EU.BY_HM.BY_HM_Minsk; _dy_df_geo=Belarus..Minsk; _dy_soct=; CookieInformationConsent=%7B%22website_uuid%22%3A%22edff3818-f291-4e5e-9dcc-d4ec01445083%22%2C%22timestamp%22%3A%222024-07-02T17%3A42%3A11.627Z%22%2C%22consent_url%22%3A%22https%3A%2F%2Fjysk.co.uk%2Fcustomer%2Ffavourites%22%2C%22consent_website%22%3A%22jysk.co.uk%22%2C%22consent_domain%22%3A%22jysk.co.uk%22%2C%22user_uid%22%3A%221a8d9e94-b755-4a00-8ec0-8a14c57db3fa%22%2C%22consents_approved%22%3A%5B%22cookie_cat_necessary%22%5D%2C%22consents_denied%22%3A%5B%22cookie_cat_functional%22%2C%22cookie_cat_statistic%22%2C%22cookie_cat_marketing%22%2C%22cookie_cat_unclassified%22%5D%2C%22user_agent%22%3A%22Mozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F126.0.0.0%20Safari%2F537.36%22%7D; _dy_csc_ses=t; _dyjsession=445c66b19b286665bfeafbb93abe6720; dy_fs_page=jysk.co.uk; _dycst=dk.w.c.ws.; sc-lead-generation-disabled=true; X-Mapping-hnbgcfhb=9033E07AB51BE78478E94C546300DCED; JSESSIONID=9634CA6254BA66B183FA9D57451DA14B; WSS_CUSTOMER_SESSION_UUID=bedb74eb-0a2d-4336-b606-3bff6273121e; _dy_ses_load_seq=22819%3A1720193862488; _dy_lu_ses=445c66b19b286665bfeafbb93abe6720%3A1720193867114; _dy_toffset=-5")
                .log().all().contentType(ContentType.JSON)
                .body(file)
                .when().post("https://jysk.co.uk/wss/json/v2/data/wishlist/wishlistitem/")
                .then().log().all().statusCode(200);
    }
    @Test(dependsOnMethods = {"postProductToTheWishlistTest"})
    public void deleteFromWishlistTest() {
        given().cookie("_dy_c_exps=; _dycnst=dg; _dyid=-2751698421416183836; _dy_geo=BY.EU.BY_HM.BY_HM_Minsk; _dy_df_geo=Belarus..Minsk; _dy_soct=; CookieInformationConsent=%7B%22website_uuid%22%3A%22edff3818-f291-4e5e-9dcc-d4ec01445083%22%2C%22timestamp%22%3A%222024-07-02T17%3A42%3A11.627Z%22%2C%22consent_url%22%3A%22https%3A%2F%2Fjysk.co.uk%2Fcustomer%2Ffavourites%22%2C%22consent_website%22%3A%22jysk.co.uk%22%2C%22consent_domain%22%3A%22jysk.co.uk%22%2C%22user_uid%22%3A%221a8d9e94-b755-4a00-8ec0-8a14c57db3fa%22%2C%22consents_approved%22%3A%5B%22cookie_cat_necessary%22%5D%2C%22consents_denied%22%3A%5B%22cookie_cat_functional%22%2C%22cookie_cat_statistic%22%2C%22cookie_cat_marketing%22%2C%22cookie_cat_unclassified%22%5D%2C%22user_agent%22%3A%22Mozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F126.0.0.0%20Safari%2F537.36%22%7D; _dy_csc_ses=t; _dyjsession=445c66b19b286665bfeafbb93abe6720; dy_fs_page=jysk.co.uk; _dycst=dk.w.c.ws.; sc-lead-generation-disabled=true; X-Mapping-hnbgcfhb=9033E07AB51BE78478E94C546300DCED; JSESSIONID=9634CA6254BA66B183FA9D57451DA14B; WSS_CUSTOMER_SESSION_UUID=bedb74eb-0a2d-4336-b606-3bff6273121e; _dy_ses_load_seq=22819%3A1720193862488; _dy_lu_ses=445c66b19b286665bfeafbb93abe6720%3A1720193867114; _dy_toffset=-5")
                .log().all().contentType(ContentType.JSON)
                .log().uri().contentType(ContentType.JSON)
                .when().delete("https://jysk.co.uk/wss/json/v2/data/wishlist/wishlistitem/3600423")
                .then().statusCode(200);
    }
}







//RestAssured.baseURI="";