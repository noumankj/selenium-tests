package com.wikia.webdriver.testcases.discussions;

import com.wikia.webdriver.common.core.Assertion;
import com.wikia.webdriver.common.core.annotations.Execute;
import com.wikia.webdriver.common.core.annotations.InBrowser;
import com.wikia.webdriver.common.core.helpers.User;
import com.wikia.webdriver.common.templates.NewTestTemplate;
import com.wikia.webdriver.pageobjectsfactory.pageobject.discussions.PostsListPage;

import org.testng.annotations.Test;

@Test(groups = "Discussions")
public class PostsListUpvote extends NewTestTemplate {

  private static final String DESKTOP_RESOLUTION = "1366x768";
  private static final String MOBILE_RESOLUTION = "600x800";

  /**
   * LOGGED IN USER ON MOBILE SECTION
   */
  @Test
  @Execute(asUser = User.USER_3)
  @InBrowser(browserSize = MOBILE_RESOLUTION)
  public void loggedInUserOnMobileCanSortPostsList() {
    postListUpvoteButtonClickAddsAnUpvoteAndSecondClickRemovesTheUpvote();
  }

  /**
   * LOGGED IN USER ON DESKTOP SECTION
   */

  @Test
  @Execute(asUser = User.USER_3)
  @InBrowser(browserSize = DESKTOP_RESOLUTION)
  public void loggedUserOnDesktopCanSwitchBetweenLatestAndTrendingTab() {
    postListUpvoteButtonClickAddsAnUpvoteAndSecondClickRemovesTheUpvote();
  }

  /**
   * TESTING METHODS SECTION
   */

  public void postListUpvoteButtonClickAddsAnUpvoteAndSecondClickRemovesTheUpvote() {
    PostsListPage postList = new PostsListPage(driver).open();
    int replyIndex = 0;
    postList.isUpvoteButtonVisible(replyIndex);
    String firstVoteCount = postList.getVoteCount(replyIndex);
    postList.clickUpvoteButton(replyIndex);
    postList.waitForVoteCountToChange(replyIndex, firstVoteCount);
    String secondVoteCount = postList.getVoteCount(replyIndex);
    Assertion.assertNotEquals(firstVoteCount, secondVoteCount);
    postList.clickUpvoteButton(replyIndex);
    postList.waitForVoteCountToChange(replyIndex, secondVoteCount);
    String thirdVoteCount = postList.getVoteCount(replyIndex);
    Assertion.assertEquals(firstVoteCount, thirdVoteCount);
  }
  
}
