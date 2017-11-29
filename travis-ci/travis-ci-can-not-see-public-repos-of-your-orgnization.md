# Travis CI Can not See Public Repositories of Your Orgnization

#### Soltion
1. Check bottom of left slide bar, you may find:

        Is an organization missing?
        Review and add your authorized organizations.

2. Click "Review and add" link

3. It'll redirect to github's settings page for application(Travis CI)

4. Under Orgnization section, click "grant" button to grant access to the repos of the orgnization for Travis CI.

5. Go to <https//travis-ci.org> home and click "Sync account".

6. You may find your orgnizations.

7. Select the orgnization, you'll see the repositories.

#### References
* [Can't see my github organizations](https://github.com/travis-ci/travis-ci/issues/2519)
