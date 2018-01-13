package pf.aqsa.com.retromvp.Presenter;

import android.content.Context;
import android.content.SharedPreferences;

import pf.aqsa.com.retromvp.View.HomeScreenViewPresenter;
import pf.aqsa.com.retromvp.View.IView;

/**
 * Created by AQSA SHaaPARR on 1/13/2018.
 */

public class HomeScreenPresenterCompl extends HomeScreenViewPresenter implements HomeScreenPresenter {

   Context context;
   public HomeScreenPresenterCompl(Context context) {
    super(context);
    this.context = context;

   //
    }

    @Override
    public void onProfileClicked() {

    }

    @Override
    public void onSettingsClicked() {

    }

    @Override
    public void setUpDrawer() {

    }

 @Override
 public void onMenuNavCreated() {

  HomeScreenPresenter hp = new HomeScreenPresenterCompl(context);

//  if (!isViewAttached()) {
//   return;
//  }
//
//  getMvpView().updateAppVersion();

//  final String currentUserName = getDataManager().getCurrentUserName();
//  SharedPreferences preferences =
//  if (currentUserName != null && !currentUserName.isEmpty()) {
//   getMvpView().updateUserName(currentUserName);
//  }
//
//  final String currentUserEmail = getDataManager().getCurrentUserEmail();
//  if (currentUserEmail != null && !currentUserEmail.isEmpty()) {
//   getMvpView().updateUserEmail(currentUserEmail);
//  }
//
//  final String profilePicUrl = getDataManager().getCurrentUserProfilePicUrl();
//  if (profilePicUrl != null && !profilePicUrl.isEmpty()) {
//   getMvpView().updateUserProfilePic(profilePicUrl);
//  }


 }
}
