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
    @Test(priority = 1)
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
        given().cookie("\n" +
                        "sc-lead-generation-disabled=true; X-Mapping-hnbgcfhb=BA1A3C19E77A196D1897BB72FB60071A; JSESSIONID=0C4CE4266A91C1B0A6FDECE666178CBA; CookieInformationConsent=%7B%22website_uuid%22%3A%22edff3818-f291-4e5e-9dcc-d4ec01445083%22%2C%22timestamp%22%3A%222024-07-08T17%3A04%3A10.604Z%22%2C%22consent_url%22%3A%22https%3A%2F%2Fjysk.co.uk%2F%22%2C%22consent_website%22%3A%22jysk.co.uk%22%2C%22consent_domain%22%3A%22jysk.co.uk%22%2C%22user_uid%22%3A%226203f185-088b-4d80-a288-139ad1584a58%22%2C%22consents_approved%22%3A%5B%22cookie_cat_necessary%22%2C%22cookie_cat_functional%22%2C%22cookie_cat_statistic%22%2C%22cookie_cat_marketing%22%2C%22cookie_cat_unclassified%22%5D%2C%22consents_denied%22%3A%5B%5D%2C%22user_agent%22%3A%22Mozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F126.0.0.0%20Safari%2F537.36%22%7D; _dyid=8709962634537737223; _dyjsession=9bf24634c340958c1b02cb0709b8129b; _dy_csc_ses=t; dy_fs_page=jysk.co.uk; _dy_df_geo=Belarus..Minsk; _dy_geo=BY.EU.BY_HM.BY_HM_Minsk; _dycnst=dg; _dycst=dk.w.c.ws.fst.; _gcl_au=1.1.1808234276.1720458251; _ga=GA1.1.1924230691.1720458249; flx1_session_id_22498=lyd8f6i2.r3t; _fbp=fb.2.1720458251207.553540118838634293; tms_VisitorID=t6fnd8f6rf; tms_wsip=1; WSS_CUSTOMER_SESSION_UUID=bc758031-7a2b-4a77-9380-bab0830d1e8a; _dy_soct=; newsPopup_state=pill; _dy_ses_load_seq=67284%3A1720458834476; _dy_lu_ses=9bf24634c340958c1b02cb0709b8129b%3A1720458837800; _dy_toffset=-1; _td=c88dee92-76b1-474b-810a-19dcbdfbc5af; _uetsid=188f87203d4c11ef885e9f0507028e50; _uetvid=188fdea03d4c11ef8d92efec849a00bc; _ga_1QC6EM8RWF=GS1.1.1720458248.1.1.1720458840.53.0.2079351394")
                .log().all().contentType(ContentType.JSON)
                .body(file)
                .when().post("https://jysk.co.uk/wss/json/v2/data/wishlist/wishlistitem/")
                .then().log().all().statusCode(200);
    }
    @Test(dependsOnMethods = {"postProductToTheWishlistTest"})
    public void deleteFromWishlistTest() {
        given().cookie("\n" +
                        "sc-lead-generation-disabled=true; X-Mapping-hnbgcfhb=BA1A3C19E77A196D1897BB72FB60071A; JSESSIONID=0C4CE4266A91C1B0A6FDECE666178CBA; CookieInformationConsent=%7B%22website_uuid%22%3A%22edff3818-f291-4e5e-9dcc-d4ec01445083%22%2C%22timestamp%22%3A%222024-07-08T17%3A04%3A10.604Z%22%2C%22consent_url%22%3A%22https%3A%2F%2Fjysk.co.uk%2F%22%2C%22consent_website%22%3A%22jysk.co.uk%22%2C%22consent_domain%22%3A%22jysk.co.uk%22%2C%22user_uid%22%3A%226203f185-088b-4d80-a288-139ad1584a58%22%2C%22consents_approved%22%3A%5B%22cookie_cat_necessary%22%2C%22cookie_cat_functional%22%2C%22cookie_cat_statistic%22%2C%22cookie_cat_marketing%22%2C%22cookie_cat_unclassified%22%5D%2C%22consents_denied%22%3A%5B%5D%2C%22user_agent%22%3A%22Mozilla%2F5.0%20%28Windows%20NT%2010.0%3B%20Win64%3B%20x64%29%20AppleWebKit%2F537.36%20%28KHTML%2C%20like%20Gecko%29%20Chrome%2F126.0.0.0%20Safari%2F537.36%22%7D; _dyid=8709962634537737223; _dyjsession=9bf24634c340958c1b02cb0709b8129b; _dy_csc_ses=t; dy_fs_page=jysk.co.uk; _dy_df_geo=Belarus..Minsk; _dy_geo=BY.EU.BY_HM.BY_HM_Minsk; _dycnst=dg; _dycst=dk.w.c.ws.fst.; _gcl_au=1.1.1808234276.1720458251; _ga=GA1.1.1924230691.1720458249; flx1_session_id_22498=lyd8f6i2.r3t; _fbp=fb.2.1720458251207.553540118838634293; tms_VisitorID=t6fnd8f6rf; tms_wsip=1; WSS_CUSTOMER_SESSION_UUID=bc758031-7a2b-4a77-9380-bab0830d1e8a; _dy_soct=; newsPopup_state=pill; _dy_ses_load_seq=67284%3A1720458834476; _dy_lu_ses=9bf24634c340958c1b02cb0709b8129b%3A1720458837800; _dy_toffset=-1; _td=c88dee92-76b1-474b-810a-19dcbdfbc5af; _uetsid=188f87203d4c11ef885e9f0507028e50; _uetvid=188fdea03d4c11ef8d92efec849a00bc; _ga_1QC6EM8RWF=GS1.1.1720458248.1.1.1720458840.53.0.2079351394")
                .log().all().contentType(ContentType.JSON)
                .log().uri().contentType(ContentType.JSON)
                .when().delete("https://jysk.co.uk/wss/json/v2/data/wishlist/wishlistitem/3600423")
                .then().statusCode(200);
    }
}







//RestAssured.baseURI="";