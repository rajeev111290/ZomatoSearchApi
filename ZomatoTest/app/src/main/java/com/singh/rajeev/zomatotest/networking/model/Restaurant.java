
package com.singh.rajeev.zomatotest.networking.model;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Restaurant implements Parcelable
{

    @SerializedName("R")
    @Expose
    private R r;
    @SerializedName("apikey")
    @Expose
    private String apikey;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("switch_to_order_menu")
    @Expose
    private Integer switchToOrderMenu;
    @SerializedName("cuisines")
    @Expose
    private String cuisines;
    @SerializedName("timings")
    @Expose
    private String timings;
    @SerializedName("average_cost_for_two")
    @Expose
    private Integer averageCostForTwo;
    @SerializedName("price_range")
    @Expose
    private Integer priceRange;
    @SerializedName("currency")
    @Expose
    private String currency;
    @SerializedName("highlights")
    @Expose
    private List<String> highlights = null;
    @SerializedName("offers")
    @Expose
    private List<Offer> offers = null;
    @SerializedName("opentable_support")
    @Expose
    private Integer opentableSupport;
    @SerializedName("is_zomato_book_res")
    @Expose
    private Integer isZomatoBookRes;
    @SerializedName("mezzo_provider")
    @Expose
    private String mezzoProvider;
    @SerializedName("is_book_form_web_view")
    @Expose
    private Integer isBookFormWebView;
    @SerializedName("book_form_web_view_url")
    @Expose
    private String bookFormWebViewUrl;
    @SerializedName("book_again_url")
    @Expose
    private String bookAgainUrl;
    @SerializedName("thumb")
    @Expose
    private String thumb;
    @SerializedName("user_rating")
    @Expose
    private UserRating userRating;
    @SerializedName("all_reviews_count")
    @Expose
    private Integer allReviewsCount;
    @SerializedName("photos_url")
    @Expose
    private String photosUrl;
    @SerializedName("photo_count")
    @Expose
    private Integer photoCount;
    @SerializedName("photos")
    @Expose
    private List<Photo> photos = null;
    @SerializedName("menu_url")
    @Expose
    private String menuUrl;
    @SerializedName("featured_image")
    @Expose
    private String featuredImage;
    @SerializedName("has_online_delivery")
    @Expose
    private Integer hasOnlineDelivery;
    @SerializedName("is_delivering_now")
    @Expose
    private Integer isDeliveringNow;
    @SerializedName("include_bogo_offers")
    @Expose
    private Boolean includeBogoOffers;
    @SerializedName("deeplink")
    @Expose
    private String deeplink;
    @SerializedName("is_table_reservation_supported")
    @Expose
    private Integer isTableReservationSupported;
    @SerializedName("has_table_booking")
    @Expose
    private Integer hasTableBooking;
    @SerializedName("events_url")
    @Expose
    private String eventsUrl;
    @SerializedName("phone_numbers")
    @Expose
    private String phoneNumbers;
    @SerializedName("all_reviews")
    @Expose
    private AllReviews allReviews;
    @SerializedName("establishment")
    @Expose
    private List<Object> establishment = null;
    @SerializedName("establishment_types")
    @Expose
    private List<Object> establishmentTypes = null;
    public final static Creator<Restaurant> CREATOR = new Creator<Restaurant>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Restaurant createFromParcel(Parcel in) {
            return new Restaurant(in);
        }

        public Restaurant[] newArray(int size) {
            return (new Restaurant[size]);
        }

    }
    ;

    protected Restaurant(Parcel in) {
        this.r = ((R) in.readValue((R.class.getClassLoader())));
        this.apikey = ((String) in.readValue((String.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.url = ((String) in.readValue((String.class.getClassLoader())));
        this.location = ((Location) in.readValue((Location.class.getClassLoader())));
        this.switchToOrderMenu = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.cuisines = ((String) in.readValue((String.class.getClassLoader())));
        this.timings = ((String) in.readValue((String.class.getClassLoader())));
        this.averageCostForTwo = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.priceRange = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.highlights, (String.class.getClassLoader()));
        in.readList(this.offers, (com.singh.rajeev.zomatotest.networking.model.Offer.class.getClassLoader()));
        this.opentableSupport = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isZomatoBookRes = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.mezzoProvider = ((String) in.readValue((String.class.getClassLoader())));
        this.isBookFormWebView = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.bookFormWebViewUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.bookAgainUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.thumb = ((String) in.readValue((String.class.getClassLoader())));
        this.userRating = ((UserRating) in.readValue((UserRating.class.getClassLoader())));
        this.allReviewsCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.photosUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.photoCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.photos, (com.singh.rajeev.zomatotest.networking.model.Photo.class.getClassLoader()));
        this.menuUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.featuredImage = ((String) in.readValue((String.class.getClassLoader())));
        this.hasOnlineDelivery = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.isDeliveringNow = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.includeBogoOffers = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.deeplink = ((String) in.readValue((String.class.getClassLoader())));
        this.isTableReservationSupported = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.hasTableBooking = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.eventsUrl = ((String) in.readValue((String.class.getClassLoader())));
        this.phoneNumbers = ((String) in.readValue((String.class.getClassLoader())));
        this.allReviews = ((AllReviews) in.readValue((AllReviews.class.getClassLoader())));
        in.readList(this.establishment, (Object.class.getClassLoader()));
        in.readList(this.establishmentTypes, (Object.class.getClassLoader()));
    }

    public Restaurant() {
    }

    public R getR() {
        return r;
    }

    public void setR(R r) {
        this.r = r;
    }

    public String getApikey() {
        return apikey;
    }

    public void setApikey(String apikey) {
        this.apikey = apikey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getSwitchToOrderMenu() {
        return switchToOrderMenu;
    }

    public void setSwitchToOrderMenu(Integer switchToOrderMenu) {
        this.switchToOrderMenu = switchToOrderMenu;
    }

    public String getCuisines() {
        return cuisines;
    }

    public void setCuisines(String cuisines) {
        this.cuisines = cuisines;
    }

    public String getTimings() {
        return timings;
    }

    public void setTimings(String timings) {
        this.timings = timings;
    }

    public Integer getAverageCostForTwo() {
        return averageCostForTwo;
    }

    public void setAverageCostForTwo(Integer averageCostForTwo) {
        this.averageCostForTwo = averageCostForTwo;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public List<String> getHighlights() {
        return highlights;
    }

    public void setHighlights(List<String> highlights) {
        this.highlights = highlights;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Integer getOpentableSupport() {
        return opentableSupport;
    }

    public void setOpentableSupport(Integer opentableSupport) {
        this.opentableSupport = opentableSupport;
    }

    public Integer getIsZomatoBookRes() {
        return isZomatoBookRes;
    }

    public void setIsZomatoBookRes(Integer isZomatoBookRes) {
        this.isZomatoBookRes = isZomatoBookRes;
    }

    public String getMezzoProvider() {
        return mezzoProvider;
    }

    public void setMezzoProvider(String mezzoProvider) {
        this.mezzoProvider = mezzoProvider;
    }

    public Integer getIsBookFormWebView() {
        return isBookFormWebView;
    }

    public void setIsBookFormWebView(Integer isBookFormWebView) {
        this.isBookFormWebView = isBookFormWebView;
    }

    public String getBookFormWebViewUrl() {
        return bookFormWebViewUrl;
    }

    public void setBookFormWebViewUrl(String bookFormWebViewUrl) {
        this.bookFormWebViewUrl = bookFormWebViewUrl;
    }

    public String getBookAgainUrl() {
        return bookAgainUrl;
    }

    public void setBookAgainUrl(String bookAgainUrl) {
        this.bookAgainUrl = bookAgainUrl;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public UserRating getUserRating() {
        return userRating;
    }

    public void setUserRating(UserRating userRating) {
        this.userRating = userRating;
    }

    public Integer getAllReviewsCount() {
        return allReviewsCount;
    }

    public void setAllReviewsCount(Integer allReviewsCount) {
        this.allReviewsCount = allReviewsCount;
    }

    public String getPhotosUrl() {
        return photosUrl;
    }

    public void setPhotosUrl(String photosUrl) {
        this.photosUrl = photosUrl;
    }

    public Integer getPhotoCount() {
        return photoCount;
    }

    public void setPhotoCount(Integer photoCount) {
        this.photoCount = photoCount;
    }

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }

    public Integer getHasOnlineDelivery() {
        return hasOnlineDelivery;
    }

    public void setHasOnlineDelivery(Integer hasOnlineDelivery) {
        this.hasOnlineDelivery = hasOnlineDelivery;
    }

    public Integer getIsDeliveringNow() {
        return isDeliveringNow;
    }

    public void setIsDeliveringNow(Integer isDeliveringNow) {
        this.isDeliveringNow = isDeliveringNow;
    }

    public Boolean getIncludeBogoOffers() {
        return includeBogoOffers;
    }

    public void setIncludeBogoOffers(Boolean includeBogoOffers) {
        this.includeBogoOffers = includeBogoOffers;
    }

    public String getDeeplink() {
        return deeplink;
    }

    public void setDeeplink(String deeplink) {
        this.deeplink = deeplink;
    }

    public Integer getIsTableReservationSupported() {
        return isTableReservationSupported;
    }

    public void setIsTableReservationSupported(Integer isTableReservationSupported) {
        this.isTableReservationSupported = isTableReservationSupported;
    }

    public Integer getHasTableBooking() {
        return hasTableBooking;
    }

    public void setHasTableBooking(Integer hasTableBooking) {
        this.hasTableBooking = hasTableBooking;
    }

    public String getEventsUrl() {
        return eventsUrl;
    }

    public void setEventsUrl(String eventsUrl) {
        this.eventsUrl = eventsUrl;
    }

    public String getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(String phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public AllReviews getAllReviews() {
        return allReviews;
    }

    public void setAllReviews(AllReviews allReviews) {
        this.allReviews = allReviews;
    }

    public List<Object> getEstablishment() {
        return establishment;
    }

    public void setEstablishment(List<Object> establishment) {
        this.establishment = establishment;
    }

    public List<Object> getEstablishmentTypes() {
        return establishmentTypes;
    }

    public void setEstablishmentTypes(List<Object> establishmentTypes) {
        this.establishmentTypes = establishmentTypes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(r);
        dest.writeValue(apikey);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(url);
        dest.writeValue(location);
        dest.writeValue(switchToOrderMenu);
        dest.writeValue(cuisines);
        dest.writeValue(timings);
        dest.writeValue(averageCostForTwo);
        dest.writeValue(priceRange);
        dest.writeValue(currency);
        dest.writeList(highlights);
        dest.writeList(offers);
        dest.writeValue(opentableSupport);
        dest.writeValue(isZomatoBookRes);
        dest.writeValue(mezzoProvider);
        dest.writeValue(isBookFormWebView);
        dest.writeValue(bookFormWebViewUrl);
        dest.writeValue(bookAgainUrl);
        dest.writeValue(thumb);
        dest.writeValue(userRating);
        dest.writeValue(allReviewsCount);
        dest.writeValue(photosUrl);
        dest.writeValue(photoCount);
        dest.writeList(photos);
        dest.writeValue(menuUrl);
        dest.writeValue(featuredImage);
        dest.writeValue(hasOnlineDelivery);
        dest.writeValue(isDeliveringNow);
        dest.writeValue(includeBogoOffers);
        dest.writeValue(deeplink);
        dest.writeValue(isTableReservationSupported);
        dest.writeValue(hasTableBooking);
        dest.writeValue(eventsUrl);
        dest.writeValue(phoneNumbers);
        dest.writeValue(allReviews);
        dest.writeList(establishment);
        dest.writeList(establishmentTypes);
    }

    public int describeContents() {
        return  0;
    }

}
