package com.wikia.webdriver.testcases.desktop.adstests;

import com.wikia.webdriver.common.core.url.UrlBuilder;
import com.wikia.webdriver.common.dataprovider.ads.AdsDataProvider;
import com.wikia.webdriver.common.driverprovider.UseUnstablePageLoadStrategy;
import com.wikia.webdriver.common.templates.TemplateNoFirstLoad;
import com.wikia.webdriver.pageobjectsfactory.pageobject.adsbase.AdsBaseObject;

import org.apache.commons.lang.StringUtils;
import org.testng.annotations.Test;

public class TestAdsDisableGpt extends TemplateNoFirstLoad {

  private static String DISASTER_RECOVERY_URL_PARAM = "InstantGlobals.wgSitewideDisableGpt=1";

  @UseUnstablePageLoadStrategy
  @Test(dataProviderClass = AdsDataProvider.class, dataProvider = "disableGptOasis", groups = "AdsDisableGptOasis")
  public void adsDisableGptOasis(
      String wikiName,
      String article,
      String instantGlobals,
      String slotName,
      String disasterProviders
  ) {
    adsDisableGpt(wikiName, article, instantGlobals, slotName, disasterProviders);
  }

  private void adsDisableGpt(
      String wikiName,
      String article,
      String instantGlobals,
      String slotName,
      String disasterProviders
  ) {

    UrlBuilder urlBuilder = UrlBuilder.createUrlBuilderForWiki(wikiName);
    String url = urlBuilder.getUrlForPath(article);
    url = urlBuilder.appendQueryStringToURL(url, DISASTER_RECOVERY_URL_PARAM);
    if (StringUtils.isNotEmpty(instantGlobals)) {
      url = urlBuilder.appendQueryStringToURL(url, instantGlobals);
    }
    new AdsBaseObject(url).verifyProvidersChain(slotName, disasterProviders);
  }
}
