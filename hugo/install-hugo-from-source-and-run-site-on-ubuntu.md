# Install Hugo from Source and Run Site on Ubuntu

## [Install Golang on Ubuntu](https://github.com/northbright/Notes/blob/master/Golang/Install/install-golang-on-ubuntu.md)

## Git Clone and Install Latest [Hugo](https://github.com/gohugoio/hugo) 

```
cd ~/
git clone https://github.com/gohugoio/hugo.git
cd ~/hugo
go install --tags extended
```

## Check Hugo Version

```
hugo version
which hugo
```

## Git Clone Hugo Site Repo

```
cd ~/
git clone git@github.com:USER/HUGO_SITE.git
```

## Initialize Theme Repo if Need(Optional)
Hugo site may use git submodule to store theme. e.g. [Hugo Clarity](https://github.com/chipzoller/hugo-clarity/#option-1-recommended)

We need to initialize and update submodule repo to fetch theme data.

```
cd ~/HUGO_SITE
git submodule init
git submodule update
``` 

## Run Hugo Server to Serve Site

```
hugo server --port 8080
```
