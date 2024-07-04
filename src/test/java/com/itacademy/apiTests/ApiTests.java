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
        given().cookie("\n" +
                        "_dy_soct=; _dy_csc_ses=t; _dycnst=dg; _dyid=2035627978184377104; _dyjsession=13c3e247e2ec0f29fcafe26dfe676de5; dy_fs_page=jysk.co.uk; _dycst=dk.w.c.ws.fst.; _dy_geo=BY.EU.BY_HM.BY_HM_Minsk; _dy_df_geo=Belarus..Minsk; sc-lead-generation-disabled=true; X-Mapping-hnbgcfhb=9033E07AB51BE78478E94C546300DCED; JSESSIONID=09DC092C5378502080DB507949FAB70C; CookieInformationConsent=%7B%22website_uuid%22%3A%22edff3818-f291-4e5e-9dcc-d4ec01445083%22%2C%22timestamp%22%3A%222024-07-04T15%3A46%3A23.895Z%22%2C%22consent_url%22%3A%22https%3A%2F%2Fjysk.co.uk%2F%22%2C%22consent_website%22%3A%22jysk.co.uk%22%2C%22consent_domain%22%3A%22jysk.co.uk%22%2C%22user_uid%22%3A%22d9e4045f-2d87-49a7-ac22-144826154b58%22%2C%22consents_approved%22%3A%5B%22cookie_cat_necessary%22%5D%2C%22consents_denied%22%3A%5B%22cookie_cat_functional%22%2C%22cookie_cat_statistic%22%2C%22cookie_cat_marketing%22%2C%22cookie_cat_unclassified%22%5D%2C%22user_agent%22%3A%22Mozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F126.0.0.0%20Safari%2F537.36%22%7D; WSS_CUSTOMER_SESSION_UUID=9fff14ed-3689-40df-bda1-b1c3c81d26f7; _dy_lu_ses=13c3e247e2ec0f29fcafe26dfe676de5%3A1720109932200; _dy_toffset=-1; _dy_ses_load_seq=5938%3A1720109945270")
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
        given().cookie("\n" +
                        "_dy_soct=; _dy_csc_ses=t; _dycnst=dg; _dyid=2035627978184377104; _dyjsession=13c3e247e2ec0f29fcafe26dfe676de5; dy_fs_page=jysk.co.uk; _dycst=dk.w.c.ws.fst.; _dy_geo=BY.EU.BY_HM.BY_HM_Minsk; _dy_df_geo=Belarus..Minsk; sc-lead-generation-disabled=true; X-Mapping-hnbgcfhb=9033E07AB51BE78478E94C546300DCED; JSESSIONID=09DC092C5378502080DB507949FAB70C; CookieInformationConsent=%7B%22website_uuid%22%3A%22edff3818-f291-4e5e-9dcc-d4ec01445083%22%2C%22timestamp%22%3A%222024-07-04T15%3A46%3A23.895Z%22%2C%22consent_url%22%3A%22https%3A%2F%2Fjysk.co.uk%2F%22%2C%22consent_website%22%3A%22jysk.co.uk%22%2C%22consent_domain%22%3A%22jysk.co.uk%22%2C%22user_uid%22%3A%22d9e4045f-2d87-49a7-ac22-144826154b58%22%2C%22consents_approved%22%3A%5B%22cookie_cat_necessary%22%5D%2C%22consents_denied%22%3A%5B%22cookie_cat_functional%22%2C%22cookie_cat_statistic%22%2C%22cookie_cat_marketing%22%2C%22cookie_cat_unclassified%22%5D%2C%22user_agent%22%3A%22Mozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F126.0.0.0%20Safari%2F537.36%22%7D; WSS_CUSTOMER_SESSION_UUID=9fff14ed-3689-40df-bda1-b1c3c81d26f7; _dy_lu_ses=13c3e247e2ec0f29fcafe26dfe676de5%3A1720109932200; _dy_toffset=-1; _dy_ses_load_seq=5938%3A1720109945270")
                .log().all().contentType(ContentType.JSON)
                .body(file)
                .when().post("https://jysk.co.uk/wss/json/v2/data/wishlist/wishlistitem/")
                .then().log().all().statusCode(200);
    }
    @Test(dependsOnMethods = {"postProductToTheWishlistTest"})
    public void deleteFromWishlistTest() {
        given().cookie("_dy_soct=; _dy_csc_ses=t; _dycnst=dg; _dyid=2035627978184377104; _dyjsession=13c3e247e2ec0f29fcafe26dfe676de5; dy_fs_page=jysk.co.uk; _dycst=dk.w.c.ws.fst.; _dy_geo=BY.EU.BY_HM.BY_HM_Minsk; _dy_df_geo=Belarus..Minsk; sc-lead-generation-disabled=true; X-Mapping-hnbgcfhb=9033E07AB51BE78478E94C546300DCED; JSESSIONID=09DC092C5378502080DB507949FAB70C; CookieInformationConsent=%7B%22website_uuid%22%3A%22edff3818-f291-4e5e-9dcc-d4ec01445083%22%2C%22timestamp%22%3A%222024-07-04T15%3A46%3A23.895Z%22%2C%22consent_url%22%3A%22https%3A%2F%2Fjysk.co.uk%2F%22%2C%22consent_website%22%3A%22jysk.co.uk%22%2C%22consent_domain%22%3A%22jysk.co.uk%22%2C%22user_uid%22%3A%22d9e4045f-2d87-49a7-ac22-144826154b58%22%2C%22consents_approved%22%3A%5B%22cookie_cat_necessary%22%5D%2C%22consents_denied%22%3A%5B%22cookie_cat_functional%22%2C%22cookie_cat_statistic%22%2C%22cookie_cat_marketing%22%2C%22cookie_cat_unclassified%22%5D%2C%22user_agent%22%3A%22Mozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F126.0.0.0%20Safari%2F537.36%22%7D; WSS_CUSTOMER_SESSION_UUID=9fff14ed-3689-40df-bda1-b1c3c81d26f7; _dy_toffset=-1; _dy_ses_load_seq=5938%3A1720109945270; _dy_lu_ses=13c3e247e2ec0f29fcafe26dfe676de5%3A1720109946789")
                .log().all().contentType(ContentType.JSON)
                .log().uri().contentType(ContentType.JSON)
                .when().delete("https://jysk.co.uk/wss/json/v2/data/wishlist/wishlistitem/3600423")
                .then().statusCode(200);
    }
}







//RestAssured.baseURI="";