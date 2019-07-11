package server.undertow.exchange;


import server.undertow.json.JsonParser;
import server.undertow.json.JsonSender;

public class Exchange {
    public static interface BodyImpl extends
            ContentTypeSenders
        , JsonSender
        , JsonParser
        {};
    private static final BodyImpl BODY = new BodyImpl(){};
    public static BodyImpl body() {
        return BODY;
    }

    public static interface QueryParamImpl extends QueryParams {};
    private static final QueryParamImpl QUERYPARAMS = new QueryParamImpl(){};
    public static QueryParamImpl queryParams() {
        return QUERYPARAMS;
    }

    public static interface PathParamImpl extends PathParams {};
    private static final PathParamImpl PATHPARAMS = new PathParamImpl(){};
    public static PathParamImpl pathParams() {
        return PATHPARAMS;
    }
}
