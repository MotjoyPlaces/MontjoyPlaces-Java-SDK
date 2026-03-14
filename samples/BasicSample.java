package com.montjoy.places;

public final class BasicSample {
    private BasicSample() {
    }

    public static void main(String[] args) {
        String apiKey = System.getenv("MONTJOY_PLACES_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("Set MONTJOY_PLACES_API_KEY before running the sample.");
        }

        MontjoyPlaces client = new MontjoyPlaces(apiKey);

        Models.WhoAmIResponse whoAmI = client.whoAmI();
        System.out.println("whoami tenant=" + whoAmI.tenantId() + " key=" + whoAmI.keyName());

        Models.GroupsListResponse groups = client.listGroups(new Models.ListGroupsRequest().limit(5));
        System.out.println("groups=" + groups.rows().stream().map(Models.Group::name).toList());

        Models.SearchResponse search = client.searchPlaces(new Models.SearchPlacesRequest("coffee near Boston MA").limit(3));
        System.out.println("search count=" + search.count());
        System.out.println(search.rows());
    }
}
