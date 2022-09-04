export default {
  siteTitle: "Tharisha Perera",
  siteDescription: "Personal Blog",
  favicon: "/favicon.ico",
  siteImagePath: "/images/dp.jpg",
  footer: "© 2022 : Personal Blog",
  dateFormat: "dd.MM.yyyy HH:mm",
  socialMedia: {
    facebook: "https://www.facebook.com/profile.php?id=100007492698410",
    // twitter: "ismailozcelik",
    linkedin: "https://www.linkedin.com/in/tharisha-perera",
    github: "https://github.com/TharishaPerera",
  },
  pageSize: 5,
  categories: [
    {
      name: "java",
      color: "btn-warning",
      image: "/images/categoryImages/java.jpg",
      order: 1,
    },
    {
      name: "cryptography",
      color: "btn-warning",
      image: "/images/categoryImages/cryptography.jpg",
      order: 1,
    },
  ],
  categorySettings: {
    order: "name", // name | count
    layout: "card", //button | card
    image: "",
    color: "btn-primary",
    countVisibility: true,
  },
  searchOptions: {
    includeScore: true,
    includeMatches: true,
    keys: [
      { name: "title", weight: 3 },
      { name: "description", weight: 2 },
    ],
  },
  i18n: {
    search: {
      placeholder: "Search post title and description...",
    },
    archive: {
      select: "Select Year",
    },
    page: "Page",
    resultFound: " result(s) found",
  },
};
