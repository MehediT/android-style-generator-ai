# TODO

## Chore

- [x] Change bucket name `fashion_product` to `default_image`
- [x] Remove `thumbnailUrl` in Supabase → rename to `thumbnailPath`
- [ ] Change bucket policies for `fashion_product`
- [x] Rename `negative_prompt` in Supabase → `prompt`
- [ ] Change bucket `fashion_product` to public

## Bug / Error Handling

- [ ] Handle all errors from domain layer using `try-catch` and sealed `Exception` classes for logging or UI feedback
- [ ] Handle UI error when `bytes: ByteArray` is null in `ImageDetailViewModel`

## Feature

- [ ] Library of modified pictures
- [ ] Embed all prompts (or equivalent)
- [ ] Two-step flow before generating an image
- [ ] Download or share the generated picture
- [ ] Article screen — fetch product info from a website URL or marketplace link
