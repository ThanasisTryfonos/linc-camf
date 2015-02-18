Contributing to Cloud Application Management Framework
======================================================

Thanks for your interest in this project.

Project description:
--------------------

The project aims to develop and sustain the necessary tooling that will assist Cloud application lifecycle management operations, using open standards and languages, where appropriate. As aforementioned, these operations are classified into three distinct categories: (1) application description, (2) application deployment and (3) application monitoring. CAMF will follow the Eclipse OSGi plug-in based software architecture for each of the aforementioned operations and will inherit the same look-and-feel that Eclipse users are accustomed to. To guarantee the quality of the resulting product, the project will follow designated development cycles with rigorous code reviews, unit tests and release cycles.

More information can be found on the project webpage:

- https://projects.eclipse.org/projects/technology.camf

Developer resources:
--------------------

Information regarding source code management, builds, coding standards, and more.

- https://projects.eclipse.org/projects/technology.camf/developer

Contributor License Agreement:
------------------------------

Before your contribution can be accepted by the project, you need to create and electronically sign the Eclipse Foundation Contributor License Agreement (CLA).

- http://www.eclipse.org/legal/CLA.php

Reporting bugs
--------------

For anything other than small changes, it's a good idea to open a bug
report for it (in case one doesn't already exist). This gives others the
chance to give input and is useful for tracking. Create one here:

https://bugs.eclipse.org/bugs/enter_bug.cgi?product=Camf


Submitting changes
------------------

We use Gerrit to review all changes by committers or contributors before
they are merged:

https://git.eclipse.org/r/

Make sure you have an account and have set up the `commit-msg` hook
before committing.

When committing your changes, see the contributor guide or other commits
on what your commit message should include.

Run the following to push your change for review (with `username`
replaced by your Gerrit username):

    git push ssh://username@git.eclipse.org:29418/camf/org.eclipse.camf HEAD:refs/for/master

Add the link to the review as a comment on the bug report, so that
people coming from the bug report can find it.

Contact:
--------

Contact the project developers via the project's "dev" list.

- https://dev.eclipse.org/mailman/listinfo/camf-dev