<h1 align="center">Enso Documentation Parser</h1>

This is a standalone edition of Enso Documentation Parser and HTML Generator.
For Enso language which contains even more advancd version of Doc Parser please visit [luna/enso](https://github.com/luna/enso) repository

This is the most advanced "Markdown-ish" tool on the market, with highest performance of 7.3 mln characters parsed per second

## How to run it?

1. Install sbt
2. clone this repo and launch in it sbt
3. go to project by typing `project syntax`
4. `run`

What you'll receive is html file generated from exaple.

To create your own page simply edit "inp" in `Main.scala` file.

## TODO
- To be further simplified and more user-friendly
- No need to change projects
- Take data from outer file or create Front-end app for parser (Scala + JS?)
- Write Reference and TLDR cheatsheet



# Enso Documentation Parser Reference
### Tags
Starting from the top of the file, you can add tags.
There are 5 available tags : 
- DEPRECATED
- MODIFIED
- ADDED
- UPCOMING
- REMOVED

But if you make a mistake or type in unknown tag, parser will still run fine, producing
undefined tag called just like you've called it, ex. ALAMAKOTA

Furthermore you can add details to each tag by writing them right after tag declaration
with one space.

So if you want to declare tags, simply write them in uppercase on top of the file, before parser begins creation 
of other sections.

And this is how tags will be rendered:

### Segments
Every time you create 2 newlines, parser will start a new text segment and close the previous one. 
The first segment you'll write will go to the `Synopsis` part of the document, rest will be in the `Body`.
Synopsis is there to write a small note for coder about what this function/library etc. does, body is to 
provide details.
There are 5 possible types of segments in Doc Parser:
 - Raw - which is just a text block
 - Important - To provide important details about functionality, known errors etc.
 - Info - Just what name suggests
 - Example - Placement for your usage examples, great place to add inline/multiline code 

And this is how you invoke them
 - Raw - created automatically after two newlines
 - Important - Just add `!` before the segment title
 - Info - Just add `?` before the segment title
 - Example - Just add `>` before the segment title
 
 And this is how particular sections will look like after rendering:
