# PreferenceExample
This repository is setup to help people that have received the exception<br />
<b>java.lang.IllegalArgumentException: No view found for id 0x102036e (android:id/prefs) for fragment NotificationPreferenceFragment{a9acab9 #2 id=0x102036e}</b>

Please note that the resource id <b>"0x102036e"</b> can be different. However, the resource name should be the same <b>"android:id/prefs"</b>. Also the fragment name would be the Fragment that you are using. In my case it is <b>"NotificationPreferenceFragment"</b>.<br />
This exception can arise when attaching an instance of Fragment to the PreferenceActivity.
