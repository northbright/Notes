# Clear the Last Search Highlighting in Vim

## Solution
* Turn off highlighting until the next search

      :noh

* Turn off highlighting completely

      vi ~/.vimrc

      #### Go to the END of the file to prevent your settings overrided

      ...
      set nohlsearch

## References
* [Vim clear last search highlighting](https://stackoverflow.com/questions/657447/vim-clear-last-search-highlighting)
* [How do you make Vim unhighlight what you searched for?](https://stackoverflow.com/questions/99161/how-do-you-make-vim-unhighlight-what-you-searched-for)
